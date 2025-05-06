package org.core.domain.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<Node> next(Node start) {
        if(start.isSame(this)) {
            List<Node> movableNodes = new ArrayList<>();
            if(standNext != null) {
                movableNodes.add(standNext);
            }
            System.out.println("movalble이 없음: " + movableNodes);
            System.out.println("name = " + name);
            System.out.println(start.getName());
            System.out.println("standNext = " + standNext);
            System.out.println(forwardNext.getName());
            return movableNodes;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CornerNode that = (CornerNode) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
