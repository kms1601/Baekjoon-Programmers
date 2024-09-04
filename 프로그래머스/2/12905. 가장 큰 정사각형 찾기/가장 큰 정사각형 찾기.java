class Solution {
    private final int[] DR = {-1, -1, 0};
    private final int[] DC = {0, -1, -1};
    
    public int solution(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        int[][] dp = new int[N + 1][M + 1];
        
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i - 1][j - 1] == 0) continue;
                
                int min = 1000;
                for (int k = 0; k < 3; k++) {
                    int ni = i + DR[k];
                    int nj = j + DC[k];
                    
                    min = Math.min(min, dp[ni][nj]);
                }
                
                max = Math.max(max, min + 1);
                dp[i][j] = min + 1;
            }
        }
        return max * max;
    }
}