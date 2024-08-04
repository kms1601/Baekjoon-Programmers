import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int x = s.nextInt();
    int count = 2;
    if (x == 1) {
      System.out.println("1/1");
    } else {
      while (count * (count + 1) / 2 < x) {
        count++;
      }
      count++;
      int sum = count * (count - 1) / 2;
      if (count % 2 == 0) {
        System.out.printf("%d/%d", sum - x + 1, x - sum - 1 + count);
      } else{
        System.out.printf("%d/%d", x - sum - 1 + count, sum - x + 1);
      }

    }
    s.close();
  }
}
