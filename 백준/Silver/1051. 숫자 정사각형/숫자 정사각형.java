import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = BR.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] rect = new String[N];
        for (int n = 0; n < N; n++) {
            rect[n] = BR.readLine();
        }
        int len = Math.min(N, M);
        int max = 1;
        for (int l = 2; l <= len; l++) {
            for (int r = 0; r <= N - l; r++) {
                for (int c = 0; c <= M - l; c++) {
                    char ch = rect[r].charAt(c);
                    if (rect[r + l - 1].charAt(c) == ch && rect[r].charAt(c + l - 1) == ch & rect[r + l - 1].charAt(c + l - 1) == ch) {
                        max = l * l;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
