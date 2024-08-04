import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cipher = br.readLine();
        int[] dp = new int[cipher.length() + 1];

        if (cipher.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= cipher.length(); i++) {
            int forward = cipher.charAt(i - 2) - '0';
            int cur = cipher.charAt(i - 1) - '0';

            if (cur == 0) {
                if (forward >= 3) {
                    System.out.println(0);
                    return;
                }
            } else {
                dp[i] += dp[i - 1];
            }

            if (forward != 0 && forward * 10 + cur <= 26) {
                dp[i] += dp[i - 2];
            }

            dp[i] %= 1000000;
        }
        System.out.println(dp[cipher.length()]);
    }
}
