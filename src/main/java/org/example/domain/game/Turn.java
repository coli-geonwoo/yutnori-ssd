package org.example.domain.game;

public class Turn {

    private static final int FIRST_TURN = 1;
    private static final int MIN_TEAM_NUMBER = 1;
    private static final int MAX_TEAM_NUMBER = 4;

    private int totalTeamCount;
    private int turn;

    public Turn(int teamCount) {
        validateTeamNumber(teamCount);
        this.totalTeamCount = teamCount;
        this.turn = FIRST_TURN;
    }

    private void validateTeamNumber(int teamNumber) {
        if (teamNumber < MIN_TEAM_NUMBER || teamNumber > MAX_TEAM_NUMBER) {
            throw new RuntimeException("팀 번호가 잘못되었습니다.");
        }
    }

    public void nextTurn() {
        if (this.turn == totalTeamCount) {
            this.turn = FIRST_TURN;
            return;
        }
        this.turn++;
    }

    public int getTurn() {
        return turn;
    }
}
