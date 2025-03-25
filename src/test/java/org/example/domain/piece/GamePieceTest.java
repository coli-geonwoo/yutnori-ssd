package org.example.domain.piece;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GamePieceTest {

    private static final int MIN_TEAM_NUMBER = 1;
    private static final int MAX_TEAM_NUMBER = 4;
    private static final int MIN_PIECE_NUMBER = 1;
    private static final int MAX_PIECE_NUMBER = 5;

    @DisplayName("범위값 바깥의 팀 번호를 입력할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {MIN_TEAM_NUMBER - 1, MAX_TEAM_NUMBER + 1})
    void throwException_When_Out_of_Team_Number_Range(int teamNumber) {
        assertThatThrownBy(() -> new GamePiece(teamNumber, MIN_PIECE_NUMBER))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("정상 범위의 팀 번호로 게임 말을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {MIN_TEAM_NUMBER, MAX_TEAM_NUMBER})
    void can_Make_Game_Piece_When_Valid_Team_Number(int teamNumber) {
        assertThatCode(() -> new GamePiece(teamNumber, MIN_PIECE_NUMBER))
                .doesNotThrowAnyException();
    }

    @DisplayName("범위값 바깥의 게임 말 번호를 입력할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {MIN_PIECE_NUMBER - 1, MAX_PIECE_NUMBER + 1})
    void throwException_When_Out_of_Piece_Number_Range(int pieceNumber) {
        assertThatThrownBy(() -> new GamePiece(MIN_TEAM_NUMBER, pieceNumber))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("정상 범위의 게임 말 번호로 게임 말을 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {MIN_PIECE_NUMBER, MAX_PIECE_NUMBER})
    void can_Make_Game_Piece_When_Valid_Piece_Number(int pieceNumber) {
        assertThatCode(() -> new GamePiece(MIN_TEAM_NUMBER, pieceNumber))
                .doesNotThrowAnyException();
    }
}
