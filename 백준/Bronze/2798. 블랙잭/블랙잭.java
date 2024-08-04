import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static List<int[]> comb(int[] arr, int n) {
    List<int[]> result = new ArrayList<int[]>();
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          result.add(new int[]{arr[i], arr[j], arr[k]});
        }
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] cards = new int[n];
    for (int i = 0; i < n; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    List<int[]> combed = comb(cards, n);
    int answer = 0;
    for (int[] com : combed) {
      int sum = 0;
      for (int i : com) {
        sum += i;
      }

      if (sum <= m && sum > answer) {
        answer = sum;
      }
    }
    System.out.println(answer);
    br.close();
  }
}
