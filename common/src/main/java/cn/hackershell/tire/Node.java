package cn.hackershell.tire;

import java.util.LinkedList;

/**
 * Created by shangwen on 2017/8/12.
 */
public class Node {
    char val;
    boolean isEnd;
    int count;
    LinkedList<Node> childList;

    public Node(char c) {
        val = c;
        isEnd = false;
        count = 0;
        childList = new LinkedList<Node>();
    }

    public Node subNode(char c) {
        if (childList != null) {
            for (Node node : childList) {
                if (node.val == c) {
                    return node;
                }
            }
        }
        return null;
    }
}
