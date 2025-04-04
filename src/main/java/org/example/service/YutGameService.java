package org.example.service;

import java.util.List;
import org.example.domain.board.Node;
import org.example.domain.board.SquareBoard;
import org.example.domain.piece.GamePieceInitializer;
import org.example.domain.piece.GamePieces;
import org.example.domain.piece.GamePiecesManager;
import org.example.domain.yut.RandomYutGenerateStrategy;
import org.example.domain.yut.YutGenerateOptions;
import org.example.domain.yut.YutGenerator;
import org.example.domain.yut.YutResult;

public class YutGameService {

    private final YutGenerator yutGenerator;
    private final SquareBoard squareBoard;
    private final GamePiecesManager gamePiecesManager;

    public YutGameService(int teamCount, int pieceCount, SquareBoard squareBoard) {
        this.yutGenerator = new YutGenerator(new RandomYutGenerateStrategy());
        this.gamePiecesManager = new GamePiecesManager(new GamePieceInitializer(), teamCount, pieceCount);
        this.squareBoard = squareBoard;
    }

    public YutResult generateYut(YutGenerateOptions options, YutResult yutResult) {
        return yutGenerator.generate(options, yutResult);
    }

    public List<GamePieces> findAllPiecesByTeam(int team) {
        return gamePiecesManager.findAllPiecesByTeam(team);
    }

    public List<String> findMovablePlaces(String from, YutResult yutResult) {
        return squareBoard.next(from, yutResult).stream()
                .map(Node::getName)
                .toList();
    }

    public List<GamePieces> findCatchablePieces(String place, int team) {
        return gamePiecesManager.findCatchablePieces(place, team);
    }

    public List<GamePieces> findGroupablePieces(String place, int team) {
        return gamePiecesManager.findGroupablePieces(place, team);
    }

    public void catchPieces(String piecesId) {
        gamePiecesManager.catchPiece(piecesId);
    }

    public GamePieces groupPieces(String piecesId1, String piecesId2) {
        return gamePiecesManager.groupPieces(piecesId1, piecesId2);
    }

    public void moveTo(String pieceId, String place) {
        gamePiecesManager.moveTo(pieceId, place);
    }
}
