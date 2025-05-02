package org.example.service;

import java.util.List;
import org.example.domain.board.Board;
import org.example.domain.board.BoardType;
import org.example.domain.board.Node;
import org.example.domain.board.creator.BoardCreator;
import org.example.domain.piece.GamePieceInitializer;
import org.example.domain.piece.GamePieces;
import org.example.domain.piece.GamePiecesManager;
import org.example.domain.yut.YutResult;

public class BoardService {

    private final Board board;
    private final GamePiecesManager gamePiecesManager;

    public BoardService(int teamCount, int pieceCount, BoardType boardType) {
        this.gamePiecesManager = new GamePiecesManager(new GamePieceInitializer(), teamCount, pieceCount);
        this.board = BoardCreator.create(boardType);
    }

    public List<GamePieces> findAllPiecesByTeam(int team) {
        return gamePiecesManager.findAllPiecesByTeam(team);
    }

    public List<String> findMovablePlaces(String from, YutResult yutResult) {
        return board.next(from, yutResult).stream()
                .map(Node::getName)
                .toList();
    }

    public List<GamePieces> findCatchablePieces(String place, int team) {
        return gamePiecesManager.findCatchablePieces(place, team);
    }

    public List<GamePieces> findGroupablePieces(String place, int team) {
        return gamePiecesManager.findGroupablePieces(place, team);
    }

    public GamePieces findPieces(String piecesId) {
        return gamePiecesManager.findById(piecesId);
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
