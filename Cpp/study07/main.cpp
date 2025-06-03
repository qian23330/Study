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


    // 数组
    int nums[] = {90, 80, 70, 60, 50, 40, 30, 20, 10};
    for (int i = 0; i < 9; ++i) {
        cout << nums[i] << endl;
    }
    cout << sizeof(nums) << endl;
    cout << sizeof(nums) / sizeof(nums[0]) << endl;
    cout << (int)(size_t)nums << endl;
    cout << (int)(size_t)&nums[0] << endl;
    cout << (int)(size_t)&nums[1] << endl;

    return 0;
}
