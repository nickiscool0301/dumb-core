#include <iostream>
using namespace std;
int main()
{
    string s = "abcde";
    int arr[3] = {1, 2, 3};
    int j = 0;
    if (arr[j++]-- == 0)
    {
        cout << "true" << endl;
    }
}