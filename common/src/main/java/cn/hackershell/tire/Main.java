package cn.hackershell.tire;

/**
 * Created by shangwen on 2017/8/12.
 */
public class Main {

    private Node root;

    public Main() {
        this.root = new Node(' ');
    }

    public void insert(String word) {

        if (search(word)) return;

        Node current = root;

        for (char c : word.toCharArray()) {
            Node child = current.subNode(c);
            if (child != null) {
                current = child;
            } else {
                current.childList.add(new Node(c));
                current = current.subNode(c);
            }
            current.count++;
        }

        current.isEnd = true;

    }

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


    public void deleteWord(String word) {
        if (!search(word)) return;

        Node current = root;
        for (char c : word.toCharArray()) {
            Node child = current.subNode(c);
            if (child.count == 1) {
                current.childList.remove(child);
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }

    public static void main(String[] args) {
        Main trie = new Main();
//        trie.insert("ball");
//        trie.insert("balls");
//        trie.insert("sense");
//
//        System.out.println(trie.search("balls"));
//        System.out.println(trie.search("ba"));
//
//        trie.deleteWord("balls");
//        System.out.println(trie.search("balls"));
//        System.out.println(trie.search("ball"));
        trie.insert("ab");

        System.out.println(trie.search("a"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.search("a"));

    }
}
