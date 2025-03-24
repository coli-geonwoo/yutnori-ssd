package org.example.domain.board;

import java.util.List;

public class CornerNode implements Node {

    private final List<String> allNodeNames;
    private final String name;
    private Node before;
    private Node forwardNext;
    private Node standNext;

    public CornerNode(List<String> allNodeNames, String name) {
        this.name = name;
        this.allNodeNames = allNodeNames;
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
    public List<String> getAllNodeNames() {
        return allNodeNames;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setBefore(Node before) {
        this.before = before;
    }

    public void setForwardNext(Node forwardNext) {
        this.forwardNext = forwardNext;
    }

    public void setStandNext(Node standNext) {
        this.standNext = standNext;
    }
}
