#include <iostream>
using namespace std;


int main()
{
    // // switch 语句
    // int score = 0;
    // cin >> score;
    //
    // switch(score)
    // {
    // case 10:
    //     cout << "A" << endl;
    //     break;
    // case 9:
    //     cout << "B" << endl;
    //     break;
    // case 8:
    //     cout << "C" << endl;
    //     break;
    // default:
    //     cout << "D" << endl;
    //     break;
    // }
    //
    // // while 循环
    // int num = 0;
    // while (num < 10)
    // {
    //     cout << num << endl;
    //     num++;
    // }
    //
    //
    // // 案例
    // srand(time(0));
    // int res = rand()%100 + 1;
    //
    // int num1 = 0;
    // while (true)
    // {
    //     cin >> num1;
    //     if (res > num1)
    //     {
    //         cout << "猜测过小" << endl;
    //     }
    //     else if (res < num1)
    //     {
    //         cout << "猜测过大" << endl;
    //     }
    //     else
    //     {
    //         cout << "猜对了！" << endl;
    //         break;
    //     }
    // }

    // do while-水仙花数
    int nn = 100;
    do
    {
        int a, b, c = 0;
        a = nn % 10;
        b = nn / 10 % 10;
        c = nn / 100;
        if (pow(a, 3) + pow(b, 3) + pow(c, 3) == nn)
        {
            cout << nn << endl;
        }
        nn++;
    }
    while (nn < 1000);

    return 0;
}