package org.example.domain.board;

import java.util.List;
import java.util.Objects;

public class CentralNode implements Node {

    private final List<String> allNodeNames;
    private final String name;
    private final List<Node> before;
    private final List<Node> next;

    public CentralNode(List<String> allNodeNames, String name, List<Node> before, List<Node> next) {
        this.allNodeNames = allNodeNames;
        this.name = name;
        this.before = before;
        this.next = next;
    }

    @Override
    public List<Node> next(Node start) {
        if (start.isSame(this)) {
            return next;
        }
        for (Node nextNode : next) {
            if(nextNode.isSameLine(start)){
                return List.of(nextNode);
            }
        }
        throw new RuntimeException("윷놀이 판이 잘못 형성되었습니다.");
    }

    @Override
    public List<Node> before() {
        return before;
    }

    @Override
    public List<String> getAllNodeNames() {
        return allNodeNames;
    }

    @Override
    public String getName() {
        return name;
    }

   public void addNext(Node node) {
        next.add(node);
   }

    public void addBefore(Node node) {
        before.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CentralNode that = (CentralNode) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
