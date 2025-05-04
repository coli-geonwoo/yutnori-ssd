package org.core.domain.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.core.domain.yut.YutResult;

public class Board {

    private final Map<String, Node> boards;

    public Board(Map<String, Node> boards) {
        this.boards = boards;
    }

    public List<Node> next(String startNodeName, YutResult result) {
        Node startNode = boards.get(startNodeName);
        if(result == YutResult.BACK_DO){
            return startNode.before();
        }

        int count = result.getStep();
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
        return nextNodes.stream()
                .distinct()
                .toList();
    }
}
