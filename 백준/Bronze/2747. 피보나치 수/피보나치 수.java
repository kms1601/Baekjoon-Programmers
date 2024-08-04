import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(0, 1, n));
    }

    private static int fibonacci(int a, int b, int n) {
        if (n == 0) return a;
        return fibonacci(b, a + b, n - 1);
    }
}
