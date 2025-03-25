package org.example.domain.piece;

public class GamePiece {

    private static final int MIN_TEAM_NUMBER = 1;
    private static final int MAX_TEAM_NUMBER = 4;
    private static final int MIN_PIECE_NUMBER = 1;
    private static final int MAX_PIECE_NUMBER = 5;

    private final int team;
    private final int pieceNumber;

    public GamePiece(int team, int pieceNumber) {
        validateTeamNumber(team);
        validatePieceNumber(pieceNumber);
        this.team = team;
        this.pieceNumber = pieceNumber;
    }

    private void validatePieceNumber(int pieceNumber) {
        if(pieceNumber <  MIN_PIECE_NUMBER || pieceNumber > MAX_PIECE_NUMBER) {
            throw new RuntimeException("게임 말 번호가 잘못되었습니다.");
        }
    }

    private void validateTeamNumber(int teamNumber) {
        if(teamNumber < MIN_TEAM_NUMBER || teamNumber > MAX_TEAM_NUMBER) {
            throw new RuntimeException("팀 번호가 잘못되었습니다.");
        }
    }
}
