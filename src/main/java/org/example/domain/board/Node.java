package org.example.domain.board;

import java.util.List;

public interface Node {

    boolean isSame(Node node);

    List<Node> next(int step, Node start);

    List<Node> before();

    String getName();
}
