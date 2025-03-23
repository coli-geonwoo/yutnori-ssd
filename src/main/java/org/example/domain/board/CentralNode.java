package org.example.domain.board;

import java.io.Serializable;
import java.util.List;

public class CentralNode implements Node {

    private final String name;
    private final List<Node> before;
    private final Node forwardNext;
    private final Node standNext;

    public CentralNode(String name, List<Node> before, Node forwardNext, Node standNext) {
        this.name = name;
        this.before = before;
        this.forwardNext = forwardNext;
        this.standNext = standNext;
    }

    @Override
    public boolean isSame(Node node) {
        return false;
    }

    @Override
    public List<Node> next(int step, Node start) {
        if(start.isSame(this)) {
            return List.of(forwardNext, standNext);
        }
        return List.of(forwardNext);
    }

    @Override
    public List<Node> before() {
        return before;
    }

    @Override
    public String getName() {
        return name;
    }
}
