package org.example.domain.game;

import java.util.List;
import org.example.domain.board.Node;
import org.example.domain.board.SquareBoard;
import org.example.domain.piece.GamePieceInitializer;
import org.example.domain.piece.GamePieces;
import org.example.domain.piece.GamePiecesManager;
import org.example.domain.yut.YutResult;

public class YutGame {

    private final GamePiecesManager gamePiecesManager;
    private final SquareBoard squareBoard;

    public YutGame(int teamCount, int pieceCount, SquareBoard squareBoard) {
        this.gamePiecesManager = new GamePiecesManager(new GamePieceInitializer(), teamCount, pieceCount);
        this.squareBoard = squareBoard;
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
}
