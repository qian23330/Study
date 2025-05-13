#include <iostream>
using namespace std;

int main()
{
    int score = 0;
    cout << "请输入：" << endl;
    cin >> score;
    if (score > 100)
    {
        cout << "恭喜" << endl;
    }
    else if (score < 80)
    {
        cout << "可惜" << endl;
    }
    else
    {
        cout << "哈哈哈" << endl;
    }
    return 0;
}