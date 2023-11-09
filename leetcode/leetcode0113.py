# 力扣-0113-路径总和2
# 二叉树遍历-dfs


from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
        
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
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right = TreeNode(3)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)
    n = int(input())

    print(Solution().pathSum(root, n))