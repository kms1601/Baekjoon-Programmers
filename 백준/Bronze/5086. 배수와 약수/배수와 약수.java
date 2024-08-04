import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (true) {
      String[] inp = s.nextLine().split(" ");
      int a = Integer.parseInt(inp[0]);
      int b = Integer.parseInt(inp[1]);
      if (a + b == 0) {
        break;
      } else if (b % a == 0) {
        System.out.println("factor");
      } else if (a % b == 0) {
        System.out.println("multiple");
      } else {
        System.out.println("neither");
      }
    }
    s.close();
  }
}
