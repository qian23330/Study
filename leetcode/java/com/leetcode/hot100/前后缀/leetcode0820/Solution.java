package com.leetcode.hot100.前后缀.leetcode0820;

/*
力扣-820-单词的压缩编码
字典树/后缀
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }

    class TrieNode {
        char val;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(char val) {
            this.val = val;
        }
    }

    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public int insert(String s) {
            TrieNode cur = root;
            boolean isNew = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!cur.children.containsKey(c)) {
                    isNew = true;
                    cur.children.put(c, new TrieNode(c));
                }
                cur = cur.children.get(c);
            }
            return isNew ? s.length() + 1 : 0;
        }
    }
}
