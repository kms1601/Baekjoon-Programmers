#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N >> M;
  int arr[N + 1] = {};
  int input;
  int start, end;


  for (int i = 0; i < N; i++) {
    cin >> input;
    arr[i + 1] = arr[i] + input;
  }

  for (int i = 0; i < M; i++) {
    cin >> start >> end;
    cout << arr[end] - arr[start - 1] << "\n";
  }
  return 0;
}