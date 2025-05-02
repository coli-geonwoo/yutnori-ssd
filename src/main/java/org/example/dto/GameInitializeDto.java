package org.example.dto;

import org.example.domain.board.BoardType;

public record GameInitializeDto(
        int teamCount,
        int pieceCount,
        BoardType boardType
) {

}
