### 力扣-968-监控二叉树 ###
# 贪心


from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    # Greedy Algo:
    # 从下往上安装摄像头：跳过leaves这样安装数量最少，局部最优 -> 全局最优
    # 先给leaves的父节点安装，然后每隔两层节点安装一个摄像头，直到Head
    # 0: 该节点未覆盖
    # 1: 该节点有摄像头
    # 2: 该节点有覆盖
    def minCameraCover(self, root: TreeNode) -> int:
        # 定义递归函数
        result = [0]  # 用于记录摄像头的安装数量
        if self.traversal(root, result) == 0:
            result[0] += 1

        return result[0]

    def traversal(self, cur: TreeNode, result: List[int]) -> int:
        if not cur:
            return 2

        left = self.traversal(cur.left, result)
        right = self.traversal(cur.right, result)

        # 情况1: 左右节点都有覆盖
        if left == 2 and right == 2:
            return 0

        # 情况2:
        # left == 0 && right == 0 左右节点无覆盖
        # left == 1 && right == 0 左节点有摄像头，右节点无覆盖
        # left == 0 && right == 1 左节点无覆盖，右节点有摄像头
        # left == 0 && right == 2 左节点无覆盖，右节点覆盖
        # left == 2 && right == 0 左节点覆盖，右节点无覆盖
        elif left == 0 or right == 0:
            result[0] += 1
            return 1

        # 情况3:
        # left == 1 && right == 2 左节点有摄像头，右节点有覆盖
        # left == 2 && right == 1 左节点有覆盖，右节点有摄像头
        # left == 1 && right == 1 左右节点都有摄像头
        else:
            return 2


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().minCameraCover(root))
