package com.leetcode.hot100.前缀.leetcode0208;

/*
力扣-208-实现 Trie (前缀树)
hot100-前缀树-哈希
 */

import java.util.HashMap;
import java.util.Map;

class Trie {
    static class Node {
        Map<Character, Node> children;
        boolean isWord;

        public Node() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char w : word.toCharArray()) {
            cur = cur.children.computeIfAbsent(w, c -> new Node());
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char w : word.toCharArray()) {
            cur = cur.children.get(w);
            if (cur == null) {
                return false;
            }
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char w : prefix.toCharArray()) {
            cur = cur.children.get(w);
            if (cur == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie myTrie = new Trie();
        myTrie.insert("word");
        System.out.println(myTrie.search("word"));
        System.out.println(myTrie.startsWith("w"));
    }
}
