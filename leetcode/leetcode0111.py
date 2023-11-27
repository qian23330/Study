# 力扣-0111-二叉树的最小深度
# 二叉树遍历-层序遍历


import collections
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        depth = 0
        queue = collections.deque([root])
        
        while queue:
            depth += 1 
            for _ in range(len(queue)):
                node = queue.popleft()
                
                if not node.left and not node.right:
                    return depth
            
                if node.left:
                    queue.append(node.left)
                    
                if node.right:
                    queue.append(node.right)

        return depth


if __name__ == '__main__':
    list = list(map(int, input().split()))
    root = construct_binary_tree(list)
    print(Solution().minDepth(root))
