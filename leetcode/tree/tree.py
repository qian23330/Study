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
        if nums[i] != -1:
            node = TreeNode(nums[i])
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


# 算法:中序遍历二叉树
def print_tree(root: TreeNode) -> []:
    T = []
    if not root:
        return
    print_tree(root.left)
    T.append(root.val)
    print_tree(root.right)
    return T
