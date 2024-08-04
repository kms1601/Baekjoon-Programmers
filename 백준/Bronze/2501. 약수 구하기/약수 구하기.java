import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(s.nextLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int count = 0;
    boolean notFound = true;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        if (++count == k) {
          System.out.println(i);
          notFound = false;
          break;
        }
      }
    }
    if (notFound) {
      System.out.println(0);
    }
  }
}
