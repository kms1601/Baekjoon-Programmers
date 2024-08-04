import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        char[] str = s.next().toCharArray();
        int sum = 0;

        for (char c : str) {
            sum += (int) c - '0';
        }
        System.out.println(sum);
        s.close();
    }
}