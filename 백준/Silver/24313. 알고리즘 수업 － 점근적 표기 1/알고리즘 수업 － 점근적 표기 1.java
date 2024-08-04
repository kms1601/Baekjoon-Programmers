import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String[] coef = s.nextLine().split(" ");
    int a1 = Integer.parseInt(coef[0]);
    int a0 = Integer.parseInt(coef[1]);
    int c = s.nextInt();
    int n = s.nextInt();
    int answer = 0;
    
    if (a1 == c && a0 <= 0){
      answer = 1;
    } else if (a1 < c && (a1 - c) * n + a0 <= 0) {
      answer = 1;
    }
    System.out.println(answer);
  }
}