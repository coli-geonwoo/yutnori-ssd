package org.example.domain.board;

import java.util.List;

public interface Node {

    List<Node> next(int step, Node start);

    List<Node> before();

    List<String> getAllNodeNames();

    String getName();

    default boolean isSame(Node node) {
        return this.getName().equals(node.getName());
    }

    default boolean isSameLine(Node node) {
        List<String> names = this.getAllNodeNames();
        List<String> targetNames = node.getAllNodeNames();
        for(String name : names){
            char lineChar = name.charAt(0);
            for(String targetName : targetNames){
                char targetLine = targetName.charAt(0);
                if(lineChar == targetLine){
                    return true;
                }
            }
        }
        return false;
    }
}
