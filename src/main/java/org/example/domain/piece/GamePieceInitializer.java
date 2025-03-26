package org.example.domain.piece;

import java.util.ArrayList;
import java.util.List;

public class GamePieceInitializer {

    public List<GamePieces> initialize(int teamCount, int pieceCount, String startPlace) {
        List<GamePieces> gamePieces = new ArrayList<>();
        for (int i = 1; i <= teamCount; i++) {
            for (int j = 1; j <= pieceCount; j++) {
                List<GamePiece> pieces = new ArrayList<>();
                pieces.add(new GamePiece(j));
                gamePieces.add(new GamePieces(i, startPlace, pieces));
            }
        }
        return gamePieces;
    }
}
