package org.view.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.core.domain.board.BoardType;
import org.core.dto.NodeViewDto;

public class BoardViewMapper {

    private final List<ViewInformation> pool;

    public BoardViewMapper() {
        this.pool = initializePool();
    }

    private List<ViewInformation> initializePool() {
        List<ViewInformation> pool = new ArrayList<>();
        pool.addAll(Arrays.asList(SquareBoardViewInformation.values()));
        pool.addAll(Arrays.asList(HexagonBoardViewInformation.values()));
        pool.addAll(Arrays.asList(PentagonBoardViewInformation.values()));
        return pool;
    }

    public List<NodeViewDto> mapTo(BoardType boardType) {
        return pool.stream()
                .filter(viewInfo -> viewInfo.isType(boardType))
                .map(viewInfo -> new NodeViewDto(viewInfo.getNodeName(), viewInfo.getX(), viewInfo.getY()))
                .toList();
    }
}