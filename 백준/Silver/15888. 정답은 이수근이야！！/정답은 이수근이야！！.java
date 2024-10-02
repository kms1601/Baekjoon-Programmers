import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = BR.readLine().split(" ");
        double A = Double.parseDouble(input[0]);
        double B = Double.parseDouble(input[1]);
        double C = Double.parseDouble(input[2]);

        double inner = B * B - 4 * A * C;
        if (inner <= 0) {
            System.out.println("둘다틀렸근");
            return;
        }
        double a = (-B + Math.sqrt(inner)) / (2 * A);
        double b = (-B - Math.sqrt(inner)) / (2 * A);

        if (a % 1 != 0 || b % 1 != 0) {
            System.out.println("둘다틀렸근");
            return;
        }

        double log2a = log2(a);
        double log2b = log2(b);

        if (log2a != 0 && log2a % 1 == 0 && log2b != 0 && log2b % 1 == 0) {
            System.out.println("이수근");
        } else {
            System.out.println("정수근");
        }
    }

    private static double log2(double a) {
        if (a <= 0) return 0.1;
        return Math.log(a) / Math.log(2);
    }
}
