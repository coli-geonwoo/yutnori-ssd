package org.example.domain.piece;

import java.util.ArrayList;
import java.util.List;

public class GamePieceInitializer {

    private static final String GAME_START_PLACE_NAME = "S0";

    public List<GamePieces> initialize(int teamCount, int pieceCount) {
        List<GamePieces> teamPieces = new ArrayList<>();
        for (int i = 1; i <= teamCount; i++) {
            for (int j = 1; j <= pieceCount; j++) {
                List<GamePiece> pieces = new ArrayList<>();
                pieces.add(new GamePiece(j));
                teamPieces.add(new GamePieces(i, GAME_START_PLACE_NAME, pieces));
            }
        }
        return teamPieces;
    }
}
