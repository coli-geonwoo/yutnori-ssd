package org.example.domain.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SquareBoard {

    private final Map<String, Node> boards;

    public SquareBoard(Map<String, Node> boards) {
        this.boards = boards;
    }

    public List<Node> next(Node startNode, int count) {
        List<Node> nextNodes = new ArrayList<>();
        nextNodes.add(startNode);
        while(count > 0) {
            List<Node> tempNodes = new ArrayList<>();
            for (Node node : nextNodes) {
                tempNodes.addAll(node.next(startNode));
            }
            nextNodes = tempNodes;
            count--;
        }
        return nextNodes;
    }

    public List<Node> before(Node node) {
        return node.before();
    }
}
