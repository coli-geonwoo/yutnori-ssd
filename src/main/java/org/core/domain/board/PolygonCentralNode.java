package org.core.domain.board;

import java.util.List;

public class PolygonCentralNode implements Node {

    private final List<String> allNodeNames;
    private final String name;
    private final List<Node> before;
    private Node shortestPathNode;
    private Node secondShortestPathNode;

    public PolygonCentralNode(
            List<String> allNodeNames,
            String name,
            List<Node> before
    ) {
        this.allNodeNames = allNodeNames;
        this.name = name;
        this.before = before;
    }

    @Override
    public List<Node> next(Node start) {
        if(start.isSame(this)) {
            return List.of(shortestPathNode);
        }
        return List.of(secondShortestPathNode);
    }

    @Override
    public List<Node> before() {
        return before;
    }

    public void addBefore(Node node) {
        before.add(node);
    }


    public void setSecondShortestPathNode(Node secondShortestPathNode) {
        this.secondShortestPathNode = secondShortestPathNode;
    }

    public void setShortestPathNode(Node shortestPathNode) {
        this.shortestPathNode = shortestPathNode;
    }

    @Override
    public List<String> getAllNodeNames() {
        return allNodeNames;
    }

    @Override
    public String getName() {
        return name;
    }
}
