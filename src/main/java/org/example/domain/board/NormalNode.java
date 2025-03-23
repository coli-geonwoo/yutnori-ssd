package org.example.domain.board;

import java.util.List;

public class NormalNode implements Node {

    private final String name;
    private final Node before;
    private final Node next;

    public NormalNode(String nodeName, Node before, Node next) {
        this.name = nodeName;
        this.before = before;
        this.next = next;
    }

    @Override
    public boolean isSame(Node node) {
        return name.equals(node.getName());
    }

    @Override
    public List<Node> next(int step, Node start) {
        return List.of(next);
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
