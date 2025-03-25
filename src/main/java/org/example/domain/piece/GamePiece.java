package org.example.domain.piece;

public class GamePiece {

    private static final int MIN_PIECE_NUMBER = 1;
    private static final int MAX_PIECE_NUMBER = 5;

    private final int pieceNumber;

    public GamePiece(int pieceNumber) {
        validatePieceNumber(pieceNumber);
        this.pieceNumber = pieceNumber;
    }

    private void validatePieceNumber(int pieceNumber) {
        if(pieceNumber <  MIN_PIECE_NUMBER || pieceNumber > MAX_PIECE_NUMBER) {
            throw new RuntimeException("게임 말 번호가 잘못되었습니다.");
        }
    }
}
