import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        int[] visible = new int[1001];
        boolean[][] visited = new boolean[1001][1001];
        for (int x = 1; x < 1001; x++) {
            for (int y = 1; y < x; y++) {
                int gcd = gcd(x, y);
                int gx = x / gcd;
                int gy = y / gcd;
                if (!visited[gx][gy]) {
                    visited[gx][gy] = true;
                    visible[x] += 2;
                }
            }
        }
        visible[1] += 3;
        for (int i = 1; i < 1001; i++) {
            visible[i] += visible[i - 1];
        }

        int C = Integer.parseInt(BR.readLine());
        for (int c = 0; c < C; c++) {
            System.out.println(visible[Integer.parseInt(BR.readLine())]);
        }
    }
}
