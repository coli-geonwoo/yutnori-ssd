package org.core.domain.board;

import java.util.stream.Stream;

public enum BoardType {
    SQUARE(4),
    PENTAGON(5),
    HEXAGON(6),
    ;

    private int type;

    BoardType(int type) {
        this.type = type;
    }

    public static BoardType mapTo(int boardType) {
        return Stream.of(values())
                .filter(value -> value.type == boardType)
                .findAny()
                .orElseThrow(() -> new RuntimeException("지원되지 않는 윷놀이 보드판입니다"));
    }
}
