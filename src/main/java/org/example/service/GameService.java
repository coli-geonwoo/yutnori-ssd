package org.example.service;

import java.util.List;
import org.example.domain.board.BoardType;
import org.example.domain.game.ScoreBoard;
import org.example.domain.game.Turn;
import org.example.domain.piece.GamePieces;
import org.example.domain.yut.RandomYutGenerateStrategy;
import org.example.domain.yut.YutGenerateOptions;
import org.example.domain.yut.YutGenerator;
import org.example.domain.yut.YutResult;

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

    public YutResult generateYut(YutGenerateOptions options, YutResult yutResult) {
        return yutGenerator.generate(options, yutResult);
    }

    public List<GamePieces> findAllPieces() {
        return boardService.findAllPiecesByTeam(turn.getTurn());
    }

    public List<String> findMovablePlaces(String from, YutResult yutResult) {
        return boardService.findMovablePlaces(from, yutResult);
    }

    public List<GamePieces> findCatchablePieces(String place) {
        return boardService.findCatchablePieces(place, turn.getTurn());
    }

    public List<GamePieces> findGroupablePieces(String place) {
        return boardService.findGroupablePieces(place, turn.getTurn());
    }

    public void catchPieces(String piecesId) {
        boardService.catchPieces(piecesId);
    }

    public GamePieces groupPieces(String piecesId1, String piecesId2) {
        return boardService.groupPieces(piecesId1, piecesId2);
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
