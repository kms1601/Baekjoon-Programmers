import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    ArrayList<Integer> primes = new ArrayList<Integer>();
    ArrayList<Integer> selected = new ArrayList<Integer>();
    int m = s.nextInt();
    int n = s.nextInt();

    for (int num = 2; num <= n; num++) {
      boolean is_prime = true;
      for (int prime : primes) {
        if (num % prime == 0) {
          is_prime = false;
          break;
        }
      }

      if (is_prime) {
        primes.add(num);

        if (num >= m) {
          selected.add(num);
        }
      }
    }

    if (selected.isEmpty()) {
      System.out.println(-1);
    } else {
      int sum = 0;
      for (int prime : selected) {
        sum += prime;
      }
      System.out.println(sum);
      System.out.println(selected.get(0));
    }
    s.close();
  }
}
