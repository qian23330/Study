### 美团笔试-春招/实习 24-03-23 ###

# 小美的回文子串
# 小美有一个长为 n的字符串s，她希望删除尽可能少的字符，使得字符串不含长度为偶数的回文子串。
# 她想知道她最少要删除几个字符，请你帮帮她吧。
# 输入描述
# 输入包含两行。
# 第一行一个正整数n(1<=n<=10^5)，表示字符串s的长度。
# 第二行一个长为n字符串s。
# 输出描述
# 输出包含一行一个整数，表示最少删除数量。
# 补充说明
# 子串：一个字符串从头或尾删除若干个（也可以不删）得到的结果字符串。回文：一个字符串正着读和倒着读一样，则该字符串回文。


n = int(input())
string = input()

res = 0
for i, c in enumerate(string):
    if i > 0 and c == string[i - 1]:
        res += 1

print(res)