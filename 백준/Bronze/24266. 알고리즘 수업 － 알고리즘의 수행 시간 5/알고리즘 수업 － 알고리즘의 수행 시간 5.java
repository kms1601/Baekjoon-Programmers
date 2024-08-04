import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    BigInteger n = new BigInteger(s.nextLine());
    System.out.println(n.multiply(n).multiply(n));
    System.out.println(3);
  }
}
