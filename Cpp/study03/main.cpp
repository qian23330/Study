#include <iostream>
using namespace std;

int main()
{
    // 运算符
    int a1 = 10;
    int b1 = 3;
    cout << b1 - a1 << endl;
    cout << a1 / b1 << endl;  // 整数相除结果是整数，去除小数部分

    double d1 = 0.5;
    double d2 = 0.22;
    cout << d1 / d2 << endl;  // 结果可以是小数

    int a2 = 10;
    int b2 = 3;
    cout << a2 % b2 << endl;  // 小数不可以取模

    return 0;
}