import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[] minMax = new int[]{10000, -10000, 10000, -10000};
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (x < minMax[0]) {
        minMax[0] = x;
      }

      if (x > minMax[1]) {
        minMax[1] = x;
      }

      if (y < minMax[2]) {
        minMax[2] = y;
      }

      if (y > minMax[3]) {
        minMax[3] = y;
      }
    }
    System.out.println((minMax[1] - minMax[0]) * (minMax[3] - minMax[2]));
  }
}
