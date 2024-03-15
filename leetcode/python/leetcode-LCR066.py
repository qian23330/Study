# 力扣-LCR066-键值映射
# 哈希


class MapSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map = {}

    def insert(self, key: str, val: int) -> None:
        self.map[key] = val

    def sum(self, prefix: str) -> int:
        result = 0
        for k, v in self.map.items():
            if k.startswith(prefix):
                result += v
        return result

