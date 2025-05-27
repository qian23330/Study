#include <iostream>
using namespace std;


int main() {
    // 案例-敲桌子
//    int num = 0;
//    while (num++ < 100)
//    {
//        if (num % 10 == 7)
//        {
//            cout << "敲桌子" << endl;
//        }
//        else if (num / 10 == 7)
//        {
//            cout << "敲桌子" << endl;
//        }
//        else if (num % 7 == 0)
//        {
//            cout << "敲桌子" << endl;
//        }
//        else
//        {
//            cout << num << endl;
//        }
//    }

    for (int i = 1; i < 100; i++) {
        if (i % 10 == 7)
        {
            cout << "敲桌子" << endl;
        }
        else if (i / 10 == 7)
        {
            cout << "敲桌子" << endl;
        }
        else if (i % 7 == 0)
        {
            cout << "敲桌子" << endl;
        }
        else
        {
            cout << i << endl;
        }
    }
    return 0;
}
