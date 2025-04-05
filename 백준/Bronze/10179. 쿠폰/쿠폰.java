import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        for (int i = 0; i < N; i++) {
            double price = Double.parseDouble(BR.readLine());
            System.out.printf("$%.2f%n", price * 0.8);
        }
    }
}
