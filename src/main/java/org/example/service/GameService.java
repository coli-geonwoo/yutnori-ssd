package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.example.domain.board.BoardType;
import org.example.domain.game.ScoreBoard;
import org.example.domain.game.Turn;
import org.example.domain.piece.GamePieces;
import org.example.domain.yut.RandomYutGenerateStrategy;
import org.example.domain.yut.YutGenerateOptions;
import org.example.domain.yut.YutGenerator;
import org.example.domain.yut.YutResult;
import org.example.dto.YutGenerationRequest;

public class GameService {

    private final BoardType boardType;
    private final Turn turn;
    private final ScoreBoard scoreBoard;
    private final YutGenerator yutGenerator;
    private final BoardService boardService;

    public GameService(int teamCount, int pieceCount, BoardType boardType) {
        this.boardType = boardType;
        this.turn = new Turn(teamCount);
        this.scoreBoard = new ScoreBoard(teamCount, pieceCount);
        this.yutGenerator = new YutGenerator(new RandomYutGenerateStrategy());
        this.boardService = new BoardService(teamCount, pieceCount, boardType);
    }

    public List<YutResult> makeTurnYutResults(Function<Integer, YutGenerationRequest> readYutGenerationInfo) {
        YutResult yutResult;
        List<YutResult> turnYutResults = new ArrayList<>();

        do {
            YutGenerationRequest request = readYutGenerationInfo.apply(turn.getTurn());
            yutResult = yutGenerator.generate(request.options(), request.yutResult());
            turnYutResults.add(yutResult);
        } while (yutResult == YutResult.YUT || yutResult == YutResult.MO);

        return turnYutResults;
    }

    public List<GamePieces> findAllPieces() {
        return boardService.findAllPiecesByTeam(turn.getTurn());
    }

    public List<String> findMovablePlaces(String from, YutResult yutResult) {
        return boardService.findMovablePlaces(from, yutResult);
    }

    public void catchPieces(String place, Function<List<GamePieces>, GamePieces> readCatchingPiece) {
        List<GamePieces> catchablePieces = boardService.findCatchablePieces(place, turn.getTurn());

        if (catchablePieces.isEmpty()) {
            return;
        }

        if (catchablePieces.size() == 1) {
            GamePieces catchablePiece = catchablePieces.get(0);
            boardService.catchPieces(catchablePiece.getId());
            return;
        }

        GamePieces catchingPiece = readCatchingPiece.apply(catchablePieces);
        boardService.catchPieces(catchingPiece.getId());
    }

    public void groupingPieces(String movingPieceId, String place, Function<List<GamePieces>, GamePieces> readGroupingPiece) {
        List<GamePieces> groupablePieces = boardService.findGroupablePieces(place, turn.getTurn());

        if (groupablePieces.isEmpty()) {
            return;
        }

        GamePieces groupingPiece = readGroupingPiece.apply(groupablePieces);

        if (groupingPiece == null) {
            return;
        }
        boardService.groupPieces(movingPieceId, groupingPiece.getId());
    }

    public void moveTo(String pieceId, String place) {
        if (place.equals("END")) {
            GamePieces gamePieces = boardService.findPieces(pieceId);
            scoreBoard.score(turn.getTurn(), gamePieces.getCount());
        }
        boardService.moveTo(pieceId, place);
    }

    public void nextTurn() {
        turn.nextTurn();
    }

    public boolean isEndGame() {
        return scoreBoard.isEnd();
    }

    public int getWinner() {
        return scoreBoard.getWinner();
    }

    public BoardType getBoardType() {
        return boardType;
    }
}
