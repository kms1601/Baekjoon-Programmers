import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] change = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        int n = 1000 - Integer.parseInt(BR.readLine());
        int count = 0;
        for (int c : change) {
            count += n / c;
            n %= c;
        }
        System.out.println(count);
    }
}
