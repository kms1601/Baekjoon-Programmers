import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] coef = new int[6];
    for (int i = 0; i < 6; i++) {
      coef[i] = Integer.parseInt(st.nextToken());
    }

    for (int x = -999; x <= 999; x++) {
      for (int y = -999; y <= 999; y++) {
        if (coef[0] * x + coef[1] * y == coef[2] && coef[3] * x + coef[4] * y == coef[5]) {
          System.out.printf("%d %d", x, y);
          break;
        }
      }
    }
  }
}
