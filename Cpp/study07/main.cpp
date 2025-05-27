#include <iostream>

using namespace std;


int main() {
    // 嵌套循环
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            cout << "* ";
        }
        cout << endl;
    }
    
    // 乘法口诀表
    for (int i = 1; i <= 9; ++i) {
        for (int j = 0; j <= i; ++j) {
            cout << j << "x"  << i << "=" << j * i << " ";
        }
        cout << endl;
    }
    return 0;
}
