import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String[] str = s.nextLine().trim().split(" ");
    if (!str[0].equals("")) {
      System.out.println(str.length);
    } else {
      System.out.println(0);
    }
    s.close();
  }
}