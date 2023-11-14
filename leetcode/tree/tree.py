import collections
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# 由数组转二叉树
def construct_binary_tree(nums: []) -> TreeNode:
    if not nums:
        return None
    # 用于存放构建好的节点
    root = TreeNode(-1)
    Tree = []
    # 将数组元素全部转化为树节点
    for i in range(len(nums)):
        if nums[i] != 'null':
            node = TreeNode(int(nums[i]))
        else:
            node = None
        Tree.append(node)
        if i == 0:
            root = node
    # 直接判断2*i+2<len(Tree)会漏掉2*i+1=len(Tree)-1的情况
    for i in range(len(Tree)):
        if Tree[i] and 2 * i + 1 < len(Tree):
            Tree[i].left = Tree[2 * i + 1]
            if 2 * i + 2 < len(Tree):
                Tree[i].right = Tree[2 * i + 2]
    return root


def print_tree(root: Optional[TreeNode]) -> List[int]:
    if not root:
        return []
    queue = collections.deque([root])
    result = []
    while queue:
        # level = []
        for _ in range(len(queue)):
            cur = queue.popleft()
            result.append(cur.val)
            if cur.left:
                queue.append(cur.left)
            if cur.right:
                queue.append(cur.right)
        # result.append(level)
    print(result)

