### 力扣-406-根据身高重建队列 ###
# 贪心


from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # 先按照h维度的身高顺序从高到低排序。确定第一个维度
        # lambda返回的是一个元组：当-x[0](维度h）相同时，再根据x[1]（维度k）从小到大排序
        people.sort(key=lambda x: (-x[0], x[1]))
        que = []

        # 根据每个元素的第二个维度k，贪心算法，进行插入
        # people已经排序过了：同一高度时k值小的排前面。
        for p in people:
            que.insert(p[1], p)
        return que


if __name__ == '__main__':
    people = [[int(num) for num in member.split(',')] for member in input().split()]
    print(Solution().reconstructQueue(people))
