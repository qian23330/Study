# 力扣-0637-二叉树的层平均值
# 二叉树遍历-层序遍历

import collections
from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        if not root:
            return []

        queue = collections.deque([root])
        averages = []
        
        while queue:
            size = len(queue)
            level_sum = 0
            
            for i in range(size):
                node = queue.popleft()
                level_sum += node.val                   
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            averages.append(level_sum / size)
        
        return averages
    

if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().averageOfLevels(root))