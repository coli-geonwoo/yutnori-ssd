package org.example.domain.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SquareBoardCreator {
    private static final CornerNode s0 = new CornerNode(List.of("S0", "AO", "D5", "F5"), "S0");
    private static final CornerNode s1 = new CornerNode(List.of("S1", "EO", "BO", "A5"), "S1");
    private static final CornerNode s2 = new CornerNode(List.of("S2", "B5", "C0", "F0"), "S2");
    private static final CornerNode s3 = new CornerNode(List.of("S3", "C5", "D0", "E5"), "S3");
    private static final CentralNode s4 = new CentralNode(List.of("S4"), "S4", new ArrayList<>(), new ArrayList<>());

    private static final NormalNode a1 = new NormalNode("A1");
    private static final NormalNode a2 = new NormalNode("A2");
    private static final NormalNode a3 = new NormalNode("A3");
    private static final NormalNode a4 = new NormalNode("A4");

    private static final NormalNode b1 = new NormalNode("B1");
    private static final NormalNode b2 = new NormalNode("B2");
    private static final NormalNode b3 = new NormalNode("B3");
    private static final NormalNode b4 = new NormalNode("B4");

    private static final NormalNode c1 = new NormalNode("C1");
    private static final NormalNode c2 = new NormalNode("C2");
    private static final NormalNode c3 = new NormalNode("C3");
    private static final NormalNode c4 = new NormalNode("C4");

    private static final NormalNode d1 = new NormalNode("D1");
    private static final NormalNode d2 = new NormalNode("D2");
    private static final NormalNode d3 = new NormalNode("D3");
    private static final NormalNode d4 = new NormalNode("D4");

    private static final NormalNode e1 = new NormalNode("E1");
    private static final NormalNode e2 = new NormalNode("E2");
    private static final NormalNode e3 = new NormalNode("E3");
    private static final NormalNode e4 = new NormalNode("E4");

    private static final NormalNode f1 = new NormalNode("F1");
    private static final NormalNode f2 = new NormalNode("F2");
    private static final NormalNode f3 = new NormalNode("F3");
    private static final NormalNode f4 = new NormalNode("F4");

    public SquareBoard initialize() {
        linkOneSide(s0, a1, a2, a3, a4, s1);
        linkOneSide(s1, b1, b2, b3, b4, s2);
        linkOneSide(s2, c1, c2, c3, c4, s3);
        linkOneSide(s2, c1, c2, c3, c4, s3);
        linkOneSide(s3, d1, d2, d3, d4, s0);
        linkCentral(s1, e1, e2, s4, e3, e4, s3);
        linkCentral(s2, f1, f2, s4, f3, f4, s0);

        List<Node> nodes = List.of(
                a1, a2, a3, a4,
                b1, b2, b3, b4,
                c1, c2, c3, c4,
                d1, d2, d3, d4,
                e1, e2, e3, e4,
                f1, f2, f3, f4,
                s0, s1, s2, s3,
                s4
        );
        return createBoard(nodes);
    }

    private SquareBoard createBoard(List<Node> nodes) {
        Map<String, Node> map = nodes.stream()
                .collect(Collectors.toMap(Node::getName, node -> node));
        return new SquareBoard(map);
    }

    private void linkOneSide(
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

    private void linkCentral(
            CornerNode start,
            NormalNode node1,
            NormalNode node2,
            CentralNode central,
            NormalNode node3,
            NormalNode node4,
            CornerNode end
    ) {
        start.setStandNext(node1);
        node1.setBefore(start);
        node1.setNext(node2);
        node2.setBefore(start);
        node2.setNext(central);
        central.addBefore(node2);
        central.addNext(node3);
        node3.setBefore(central);
        node3.setNext(node4);
        node4.setBefore(node3);
        node4.setNext(end);
    }
}
