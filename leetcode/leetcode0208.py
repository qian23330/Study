# 力扣-208-实现 Trie (前缀树)
# 字典树/哈希


import collections


class Node:
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.isword = False


class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word):
        current = self.root
        for w in word:
            current = current.children[w]
        current.isword = True

    def search(self, word):
        current = self.root
        for w in word:
            current = current.children.get(w)
            if current is None:
                return False
        return current.isword

    def startsWith(self, prefix):
        current = self.root
        for w in prefix:
            current = current.children.get(w)
            if current is None:
                return False
        return True
