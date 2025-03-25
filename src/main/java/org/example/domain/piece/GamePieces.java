package org.example.domain.piece;

import java.util.List;

public class GamePieces {

    private static final int MIN_TEAM_NUMBER = 1;
    private static final int MAX_TEAM_NUMBER = 4;

    private final int team;
    private final List<GamePiece> pieces;

    public GamePieces(int team, List<GamePiece> pieces) {
        validateTeamNumber(team);
        this.team = team;
        this.pieces = pieces;
    }

    private void validateTeamNumber(int teamNumber) {
        if(teamNumber < MIN_TEAM_NUMBER || teamNumber > MAX_TEAM_NUMBER) {
            throw new RuntimeException("팀 번호가 잘못되었습니다.");
        }
    }

    public boolean isSameTeam(int teamNumber) {
        return this.team == teamNumber;
    }

    public void addPiece(GamePiece piece) {
        pieces.add(piece);
    }

    public List<GamePiece> getPieces() {
        return pieces;
    }
}
