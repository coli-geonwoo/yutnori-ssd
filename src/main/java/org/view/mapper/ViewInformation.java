package org.view.mapper;

import org.core.domain.board.BoardType;

public interface ViewInformation {

    int getX();

    int getY();

    String getNodeName();

    boolean isType(BoardType type);
}