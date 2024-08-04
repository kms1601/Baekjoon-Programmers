import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] numArr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int num = s.nextInt();
            numArr[i] = num;
            sum += num;
        }
        Arrays.sort(numArr);
        System.out.println(sum / 5);
        System.out.println(numArr[2]);
        s.close();
    }
}
