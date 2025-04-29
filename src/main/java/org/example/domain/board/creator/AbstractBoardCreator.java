package org.example.domain.board.creator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.domain.board.Board;
import org.example.domain.board.CornerNode;
import org.example.domain.board.EndNode;
import org.example.domain.board.Node;
import org.example.domain.board.NormalNode;

public abstract class AbstractBoardCreator {

    protected final void linkEnd(CornerNode startNode, CornerNode cornerNode, EndNode end) {
        startNode.setBefore(end);
        cornerNode.setForwardNext(end);
        cornerNode.setStandNext(end);
    }

    protected final void linkOneSide(
            CornerNode start,
            NormalNode node1,
            NormalNode node2,
            NormalNode node3,
            NormalNode node4,
            CornerNode end
    ) {
        start.setForwardNext(node1);
        node1.setBefore(start);
        node1.setNext(node2);
        node2.setBefore(node1);
        node2.setNext(node3);
        node3.setBefore(node2);
        node3.setNext(node4);
        node4.setBefore(node3);
        node4.setNext(end);
        end.setBefore(node4);
    }

    protected final Board createBoard(List<Node> nodes) {
        Map<String, Node> map = nodes.stream()
                .collect(Collectors.toMap(Node::getName, node -> node));
        return new Board(map);
    }

    public abstract Board initialize();
}
