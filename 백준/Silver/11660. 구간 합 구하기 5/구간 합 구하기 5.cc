#include <iostream>
using namespace std;

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N >> M;
  int** table = new int*[N+1];
  int tmp;

  for (int i = 0; i <= N; i++) {
    table[i] = new int[N+1];
  }

  for (int i = 0; i <= N; i++)
  {
    for (int j = 0; j <= N; j++)
    {
      table[i][j] = 0;
    }
  }

  for (int i = 1; i <= N; i++)
  {
    for (int j = 1; j <= N; j++)
    {
      cin >> tmp;
      table[i][j] = tmp + table[i][j - 1] + table[i - 1][j] - table[i - 1][j - 1];
    }
  }

  int x1, y1, x2, y2;

  for (int i = 0; i < M; i++)
  {
    cin >> x1 >> y1 >> x2 >> y2;
    cout << table[x2][y2] - table[x1 - 1][y2] - table[x2][y1 - 1] + table[x1 - 1][y1 - 1] << "\n";
  }

  return 0;
}