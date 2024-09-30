import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int M;
    private static String[] shooting;

    public static void main(String[] args) throws IOException {
        String[] input = BR.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        shooting = new String[N];
        for (int n = 0; n < N; n++) {
            shooting[n] = BR.readLine();
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (shooting[n].charAt(m) == '1') test(n, m);
            }
        }
        System.out.println(-1);
    }

    private static void test(int n, int m) {
        boolean[] scoreList = new boolean[10];
        for (int x = -9; x <= 9; x++) {
            for (int y = -9; y <= 9; y++) {
                int nn = n + x;
                int nm = m + y;
                if (0 <= nn && nn < N && 0 <= nm && nm < M && shooting[nn].charAt(nm) == '1') {
                    int score = 9 - Math.max(Math.abs(x), Math.abs(y));
                    if (scoreList[score]) return;
                    scoreList[score] = true;
                }
            }
        }
        for (boolean b : scoreList) {
            if (!b) return;
        }
        System.out.println(n + " " + m);
        System.exit(0);
    }
}
