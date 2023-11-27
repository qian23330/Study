# 力扣-0501-二叉搜索树中的众数
# 二叉搜索树


from collections import defaultdict
from tree.tree import construct_binary_tree


class Solution:
    def searchBST(self, cur, freq_map):
        if cur is None:
            return
        freq_map[cur.val] += 1  # 统计元素频率
        self.searchBST(cur.left, freq_map)
        self.searchBST(cur.right, freq_map)

    def findMode(self, root):
        freq_map = defaultdict(int)  # key:元素，value:出现频率
        result = []
        if root is None:
            return result
        self.searchBST(root, freq_map)
        max_freq = max(freq_map.values())
        for key, freq in freq_map.items():
            if freq == max_freq:
                result.append(key)
        return result


if __name__ == '__main__':
    list = input().split()
    root = construct_binary_tree(list)

    result_tree = Solution().findMode(root)
    print(result_tree)  # 输出有问题
