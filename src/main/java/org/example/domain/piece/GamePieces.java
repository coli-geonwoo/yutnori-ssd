package org.example.domain.piece;

import java.util.List;

// TODO 전체 Piece들을 초기화하는 기능
// TODO 운영중인 내 팀 게임말 들의 위치를 보여주는 기능
// TODO 내 팀 말을 옮기는 기능 -> 업거나
public class GamePieces {

    private static final int MIN_TEAM_NUMBER = 1;
    private static final int MAX_TEAM_NUMBER = 4;

    private final int team;
    private final String place;
    private final List<GamePiece> pieces;

    public GamePieces(int team, String place, List<GamePiece> pieces) {
        validateTeamNumber(team);
        this.team = team;
        this.place = place;
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

    public GamePieces moveTo(String place) {
        return new GamePieces(this.team, place, this.pieces);
    }
}
