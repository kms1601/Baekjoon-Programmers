import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] bags = new int[N][];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int W = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            bags[i] = new int[]{W, V};
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            int[] bag = bags[i - 1];
            int weight = bag[0];
            int value = bag[1];
            for (int j = 1; j <= K; j++) {
                if (weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], value + dp[i - 1][j - weight]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
