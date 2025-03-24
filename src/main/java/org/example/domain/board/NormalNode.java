package org.example.domain.board;

import java.util.List;

public class NormalNode implements Node {

    private final String name;
    private Node before;
    private Node next;

    public NormalNode(String name) {
        this.name = name;
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
    public List<String> getAllNodeNames() {
        return List.of(name);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setBefore(Node before) {
        this.before = before;
    }
}
