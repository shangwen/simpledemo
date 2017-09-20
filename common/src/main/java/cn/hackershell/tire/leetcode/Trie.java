package cn.hackershell.tire.leetcode;

import java.util.LinkedList;

/**
 * Created by shangwen on 2017/8/13.
 */
public class Trie {

    class Node {
        char val;
        boolean isEnd;
        int count;
        LinkedList<Node> childs;

        public Node(char c) {
            this.val = c;
            this.isEnd = false;
            this.count = 0;
            this.childs = new LinkedList();
        }

        public Node subNode(char c) {
            for (Node child : childs) {
                if (child.val == c) {
                    return child;
                }
            }
            return null;
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (search(word)) return;

        Node current = root;
        for (char c : word.toCharArray()) {
            Node child = current.subNode(c);
            if (child != null) {
                current = child;
            } else {
                current.childs.add(new Node(c));
                current = current.subNode(c);
            }
            current.count++;
        }
        current.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.subNode(c) == null) {
                return false;
            } else {
                current = current.subNode(c);
            }
        }

        return current.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            if (current.subNode(c) == null) {
                return false;
            } else {
                current = current.subNode(c);
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        Trie obj = new Trie();
//        obj.insert("ab");
//        System.out.println(obj.search("a"));
//        System.out.println(obj.search("ab"));
//        System.out.println(obj.startsWith("a"));
//        System.out.println(obj.startsWith("ab"));
//
//    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
