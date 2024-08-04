import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    BigInteger n = new BigInteger(s.nextLine());
    System.out.println(n.
        multiply(n.subtract(new BigInteger("1"))).
        multiply(n.subtract(new BigInteger("2"))).
        divide(new BigInteger("6")));
    System.out.println(3);
  }
}
