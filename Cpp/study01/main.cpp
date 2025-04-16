#include <iostream>
using namespace std;


int main()
{
    // 整型
    short num1 = 10;
    cout << sizeof(num1) << endl;

    int num2 = 10;
    cout << sizeof(num2) << endl;

    long num3 = 10;
    cout << sizeof(num3) << endl;

    long long num4 = 10;
    cout << sizeof(num4) << endl;

    // 浮点型
    float f1 = 3.1415926f;
    cout << "f1 = " << f1 << endl;
    cout << sizeof(f1) << endl;
    double d1 = 3.1415926;
    cout << "d1 = " << d1 << endl;
    cout << sizeof(d1) << endl;

    float f2 = 3e-2;
    cout << "f2 = " << f2 << endl;

    // 字符型
    char ch = 'a';
    cout << ch << endl;
    cout << (int)ch << endl;
    cout << sizeof(ch) << endl;

    // 转义字符
    cout << "Hello World!\n";
    cout << "\\" << endl;
    cout << "aaa\tbbb" << endl;
    cout << "aaaa\tbbb" << endl;
    cout << "aa\tbbb" << endl;
    cout << "aaaaa\tbbb" << endl;
    cout << "a\tbbb" << endl;

    // 字符串


    return 0;
}