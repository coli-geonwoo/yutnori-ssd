package org.example.domain.piece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePiecesManager {

    private static final String GAME_START_PLACE_NAME = "S0";

    private final Map<String, List<GamePieces>> gamePieces;

    public GamePiecesManager(GamePieceInitializer initializer, int teamCount, int pieceCount) {
        List<GamePieces> pieces = initializer.initialize(teamCount, pieceCount, GAME_START_PLACE_NAME);
        this.gamePieces = initializeGamePieces(pieces);
    }

    private Map<String, List<GamePieces>> initializeGamePieces(List<GamePieces> pieces) {
        Map<String, List<GamePieces>> gamePieces = new HashMap<>();
        gamePieces.put(GAME_START_PLACE_NAME, pieces);
        return gamePieces;
    }

    public List<GamePieces> findAllPiecesByTeam(int team) {
        return gamePieces.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(piece -> piece.isSameTeam(team))
                .toList();
    }

    public List<GamePieces> findCatchablePieces(String place, int team) {
        List<GamePieces> piecesOnPlace = gamePieces.get(place);
        return piecesOnPlace.stream()
                .filter(pieces -> !pieces.isSameTeam(team))
                .toList();
    }

    public List<GamePieces> findGroupablePieces(String place, int team) {
        List<GamePieces> piecesOnPlace = gamePieces.get(place);
        return piecesOnPlace.stream()
                .filter(pieces -> pieces.isSameTeam(team))
                .toList();
    }

    public void catchPiece(String pieceId) {
        GamePieces catchPiece = findById(pieceId);
        gamePieces.get(catchPiece.getPlace())
                .remove(catchPiece);

        catchPiece.getPieces()
                .stream()
                .forEach(piece -> initializePiecesToStartPoint(piece, catchPiece.getTeam()));
    }

    private void initializePiecesToStartPoint(GamePiece piece, int team) {
        List<GamePieces> startPointPieces = gamePieces.get(GAME_START_PLACE_NAME);
        List<GamePiece> restartPiece = new ArrayList<>();
        restartPiece.add(piece);
        GamePieces restartPieces = new GamePieces(team, GAME_START_PLACE_NAME, restartPiece);
        startPointPieces.add(restartPieces);
    }

    public GamePieces groupPieces(String pieceId1, String pieceId2) {
        GamePieces piece1 = findById(pieceId1);
        GamePieces piece2 = findById(pieceId2);

        if (!piece1.onSamePlace(piece2)) {
            throw new RuntimeException("같은 위치에 있지 않습니다");
        }

        piece2.groupWith(piece1);
        gamePieces.get(piece1.getPlace())
                .remove(piece1);
        return piece2;
    }

    public void moveTo(String pieceId, String place) {
        GamePieces piece = findById(pieceId);
        gamePieces.get(piece.getPlace()).remove(piece);

        piece.moveTo(place);

        gamePieces.putIfAbsent(place, new ArrayList<>());
        gamePieces.get(place).add(piece);
    }

    public GamePieces findById(String pieceId) {
        return gamePieces.values().stream()
                .flatMap(Collection::stream)
                .filter(piece -> piece.isSame(pieceId))
                .findAny()
                .orElseThrow(() -> new RuntimeException("말이 존재하지 않습니다."));
    }
}
