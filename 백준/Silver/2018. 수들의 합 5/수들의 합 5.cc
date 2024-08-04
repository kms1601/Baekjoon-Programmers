#include <iostream>
using namespace std;

int main()
{
    int N;
    int left = 0, right = 0;
    int count = 0;
    int sum = 1;

    cin >> N;

    while (right != N - 1)
    {
        if (sum < N)
        {
            right += 1;
            sum += right + 1;
        } else 
        {
            if (sum == N) count++;
            sum -= left + 1;
            left += 1;
        }
    }
    cout << count + 1;
    return 0;
}