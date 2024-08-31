class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int max = Math.max(money[1], money[0] + money[2]);
        int[] dp = new int[n];
        dp[0] = money[0];
        dp[2] = money[0] + money[2];
        for (int i = 3; i < n - 1; i++) {
            dp[i] = money[i] + Math.max(dp[i - 2], dp[i - 3]);
            max = Math.max(max, dp[i]);
        }
        
        dp[0] = 0;
        dp[1] = money[1];
        dp[2] = money[2];
        for (int i = 3; i < n; i++) {
            dp[i] = money[i] + Math.max(dp[i - 2], dp[i - 3]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}