package org.example.domain.piece;

import java.util.List;
import java.util.UUID;

public class GamePieces {

    private static final int MIN_TEAM_NUMBER = 1;
    private static final int MAX_TEAM_NUMBER = 4;

    private final String id;
    private final int team;
    private final List<GamePiece> pieces;
    private String place;

    public GamePieces(int team, String place, List<GamePiece> pieces) {
        validateTeamNumber(team);
        this.place = place;
        this.id = UUID.randomUUID().toString();
        this.team = team;
        this.pieces = pieces;
    }

    private void validateTeamNumber(int teamNumber) {
        if(teamNumber < MIN_TEAM_NUMBER || teamNumber > MAX_TEAM_NUMBER) {
            throw new RuntimeException("팀 번호가 잘못되었습니다.");
        }
    }

    //TODO 불변으로 바꾸기
    public void moveTo(String place) {
        this.place = place;
    }

    public boolean isSameTeam(int teamNumber) {
        return this.team == teamNumber;
    }

    public boolean isSame(String pieceId){
        return this.id.equals(pieceId);
    }

    public boolean onSamePlace(GamePieces gamePiece) {
        return this.place.equals(gamePiece.place);
    }

    public void groupWith(GamePieces gamePiece) {
        pieces.addAll(gamePiece.pieces);
    }

    public List<GamePiece> getPieces() {
        return pieces;
    }

    public int getCount() {
        return pieces.size();
    }

    public String getPlace() {
        return place;
    }

    public int getTeam() {
        return team;
    }

    public String getId() {
        return id;
    }
}
