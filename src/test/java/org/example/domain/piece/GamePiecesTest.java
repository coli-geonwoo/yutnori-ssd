package org.example.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GamePiecesTest {

    private static final int MIN_TEAM_NUMBER = 1;
    private static final int MAX_TEAM_NUMBER = 4;

    @DisplayName("범위값 바깥의 팀 번호를 입력할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {MIN_TEAM_NUMBER - 1, MAX_TEAM_NUMBER + 1})
    void throw_exception_when_out_of_team_number_range(int teamNumber) {
        assertThatThrownBy(() -> new GamePieces(teamNumber, "말의 위치", List.of()))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("정상 범위의 팀 번호로 게임 말을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {MIN_TEAM_NUMBER, MAX_TEAM_NUMBER})
    void can_make_game_piece_when_valid_team_number(int teamNumber) {
        assertThatCode(() -> new GamePieces(teamNumber, "말의 위치", List.of()))
                .doesNotThrowAnyException();
    }

    @DisplayName("같은 팀의 말 그룹인지 확인할 수 있다.")
    @Test
    void can_identify_same_team() {
        GamePieces gamePieces = new GamePieces(1, "말의 위치", List.of());

        assertAll(
                () -> assertThat(gamePieces.isSameTeam(1)).isTrue(),
                () -> assertThat(gamePieces.isSameTeam(2)).isFalse()
        );
    }

    @DisplayName("게임 말을 업을 수 있다")
    @Test
    void can_add_piece() {
        List<GamePiece> pieces = new ArrayList<>();
        GamePiece gamePiece1 = new GamePiece(1);
        pieces.add(gamePiece1);
        int beforeSize = pieces.size();
        GamePieces gamePieces1 = new GamePieces(1, "말의 위치", new ArrayList<>());
        GamePieces gamePieces2 = new GamePieces(2, "말의 위치", pieces);
        gamePieces1.groupWith(gamePieces2);

        assertThat(gamePieces1.getPieces()).hasSize(beforeSize + 1);
    }
}
