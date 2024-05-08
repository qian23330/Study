package com.leetcode.hot100.链表.leetcode0146;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
力扣-146-LRU缓存
hot100-双向链表-哈希
*/

class LRUCache {
    public static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        pushFront(node);
        if (map.size() > capacity) {
            Node backNode = dummy.prev;
            map.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(0, 1);
        cache.put(0, 2);
        cache.put(1, 5);
        cache.put(2, 5);
        System.out.println(cache.get(0));
    }
}


