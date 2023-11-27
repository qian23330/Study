# 力扣-0113-路径总和2
# 二叉树遍历-dfs


from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        result = []
        self.traversal(root, targetSum, [], result)
        return result

    def traversal(self,node, count, path, result):
            if not node:
                return
            path.append(node.val)
            count -= node.val
            if not node.left and not node.right and count == 0:
                result.append(list(path))
            self.traversal(node.left, count, path, result)
            self.traversal(node.right, count, path, result)
            path.pop()
            

if __name__ == '__main__':
    list = list(map(int, input().split()))
    root = construct_binary_tree(list)
    n = int(input())
    print(Solution().pathSum(root, n))