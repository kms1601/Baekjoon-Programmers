import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (true) {
      int n = s.nextInt();
      List<Integer> numList = new ArrayList<Integer>();
      int sum = 0;

      if (n == -1) {
        break;
      }

      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          numList.add(i);
        }
      }

      for (int num : numList) {
        sum += num;
      }

      if (sum == n) {
        System.out.printf("%d = ", n);

        for (int num : numList) {
          System.out.printf("%d", num);

          if (numList.indexOf(num) + 1 != numList.size()) {
            System.out.print(" + ");
          }
        }

      } else {
        System.out.printf("%d is NOT perfect.", n);
      }
      System.out.println("");
    }
    s.close();
  }
}