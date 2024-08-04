#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;
    long arr[N + 1] = {0};
    long answer = 0;

    for (int i = 1; i <= N; i++)
    {
        cin >> arr[i];
        arr[i] += +arr[i - 1];
    }

    for (int i = 1; i <= N; i++)
    {
        arr[i] %= M;

        if (arr[i] == 0)
            answer++;
    }

    for (int i = 0; i < M; i++)
    {
        long count = 0;
        for (int j = 1; j <= N; j++)
        {
            if (arr[j] == i)
                count++;
        }
        answer += count * (count - 1) / 2;
    }
    cout << answer;
    return 0;
}