import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    int c = s.nextInt();
    int sameCount = 0;

    if (a + b + c != 180) System.out.println("Error");
    else {
      if (a == b) sameCount++;
      if (b == c) sameCount++;
      if (c == a) sameCount++;
      if (sameCount == 0) System.out.println("Scalene");
      if (sameCount == 1) System.out.println("Isosceles");
      if (sameCount == 3) System.out.println("Equilateral");
    }
  }
}