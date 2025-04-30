package org.example.view.mapper;

import java.util.List;
import java.util.stream.Stream;
import org.example.domain.board.BoardType;
import org.example.dto.NodeViewDto;

public enum SquareBoardViewInformation implements ViewInformation {

     /*
    S2  -  B4  -  B3  -  B2  -  B1  -    S1
     |  F1                         E1    |
    C1                                   A4
     |       F2               E2         |
    C2                                   A3
     |                S4                 |
    C3                                   A2
     |       E3               F3         |
    C4                                   A1
     |  E4                         F4    |
    S3  -  D1  -  D2  -  D3  -  D4  - S5 S0
                                       |
                                      END
     */

    S0("SO", 0, 0),
    S1("S1", 0, 0),
    S2("S2", 0, 0),
    S3("S3", 0, 0),
    S4("S4", 0, 0),

    A1("A1", 0, 0),
    A2("A2", 0, 0),
    A3("A3", 0, 0),
    A4("A4", 0, 0),

    B1("B1", 0, 0),
    B2("B2", 0, 0),
    B3("B3", 0, 0),
    B4("B4", 0, 0),

    C1("C1", 0, 0),
    C2("C2", 0, 0),
    C3("C3", 0, 0),
    C4("C4", 0, 0),

    D1("D1", 0, 0),
    D2("D2", 0, 0),
    D3("D3", 0, 0),
    D4("D4", 0, 0),

    E1("E1", 0, 0),
    E2("E2", 0, 0),
    E3("E3", 0, 0),
    E4("E4", 0, 0),

    F1("F1", 0, 0),
    F2("F2", 0, 0),
    F3("F3", 0, 0),
    F4("F4", 0, 0),
    ;

    private final String nodeName;
    private final int x;
    private final int y;

    SquareBoardViewInformation(String nodeName, int x, int y) {
        this.nodeName = nodeName;
        this.x = x;
        this.y = y;
    }

    public List<NodeViewDto> getNodeViews() {
        return Stream.of(values())
                .map(value -> new NodeViewDto(value.nodeName, value.x, value.y))
                .toList();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getNodeName() {
        return nodeName;
    }

    @Override
    public boolean isType(BoardType type) {
        return BoardType.HEXAGON == type;
    }
}
