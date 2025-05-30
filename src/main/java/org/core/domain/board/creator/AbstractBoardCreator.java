package org.core.domain.board.creator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.core.domain.board.Board;
import org.core.domain.board.CornerNode;
import org.core.domain.board.EndNode;
import org.core.domain.board.Node;
import org.core.domain.board.NormalNode;

public abstract class AbstractBoardCreator {

    protected final void linkEnd(CornerNode startNode, CornerNode cornerNode, EndNode end) {
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
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(end);
    }

    protected final Board createBoard(List<Node> nodes) {
        Map<String, Node> map = nodes.stream()
                .collect(Collectors.toMap(Node::getName, node -> node));
        return new Board(map);
    }

    public abstract Board initialize();
}
