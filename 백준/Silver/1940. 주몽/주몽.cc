#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;
    int ingre[N];
    int left = 0, right = N - 1;
    int count = 0;

    for (int i = 0; i < N; i++)
    {
        cin >> ingre[i];
    }
    sort(ingre, ingre + N);

    while (left < right)
    {
        int armor = ingre[left] + ingre[right];

        if (armor < M)
        {
            left++;
        }
        else if (armor > M)
        {
            right--;
        }
        else
        {
            count++;
            left++;
            right--;
        }
    }
    cout << count;
    return 0;
}