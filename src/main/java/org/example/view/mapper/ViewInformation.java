package org.example.view.mapper;

import org.example.domain.board.BoardType;

public interface ViewInformation {

    int getX();

    int getY();

    String getNodeName();

    boolean isType(BoardType type);
}
