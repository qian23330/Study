n,k = map(int,input().split())
s = input()


def max_substrings(n, k, s):
    left = 0
    right = 0
    count = 0
    char_set = set()
    while right < n:
        char_set.add(s[right])
        while len(char_set) * (right - left + 1) >= k:
            count += 1
            left = right + 1
            char_set.clear()
        right += 1
    return count


def decodeString(s: str) -> str:
    res = ''
    word = []
    temp_num = 0
    for char in s:
        if '0' <= char <= '9':
            temp_num = temp_num * 10 + int(char)
        elif char == '(':
            continue
        elif char == ')':
            res += word.pop() * temp_num
            temp_num = 0
        else:
            word.append(char)
    return res


print(max_substrings(n, k, decodeString(s)))