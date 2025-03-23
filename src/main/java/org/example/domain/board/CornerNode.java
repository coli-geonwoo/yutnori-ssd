package org.example.domain.board;

import java.util.List;

public class CornerNode implements Node {

    private final String name;
    private final Node before;
    private final Node forwardNext;
    private final Node standNext;

    public CornerNode(String name, Node before, Node forwardNext, Node standNext) {
        this.name = name;
        this.before = before;
        this.forwardNext = forwardNext;
        this.standNext = standNext;
    }

    @Override
    public boolean isSame(Node node) {
        return name.equals(node.getName());
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
        return List.of(before);
    }

    @Override
    public String getName() {
        return name;
    }

}
