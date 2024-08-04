import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] num = s.nextLine().toCharArray();
        Arrays.sort(num);

        for (int i = num.length - 1; i >= 0; i--) {
            System.out.print(num[i]);
        }
        s.close();
    }
}