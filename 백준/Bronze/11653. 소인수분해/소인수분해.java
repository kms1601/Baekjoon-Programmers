import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int divide = 2;
    while (n != 1) {
      while (n % divide == 0) {
        n /= divide;
        System.out.println(divide);
      }
      divide++;
    }
  }
}