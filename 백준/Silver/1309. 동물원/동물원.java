import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int n = 1; n < N; n++) {
            dp[n][0] = (dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901;
            dp[n][1] = (dp[n - 1][0] + dp[n - 1][2]) % 9901;
            dp[n][2] = (dp[n - 1][0] + dp[n - 1][1]) % 9901;
        }

        System.out.println((dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901);
    }
}
