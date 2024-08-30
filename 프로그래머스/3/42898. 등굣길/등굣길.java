class Solution {
    final int[] DX = {-1, 0};
    final int[] DY = {0, -1};
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] count = new int[n + 1][m + 1];
        
        for (int[] puddle : puddles) {
            count[puddle[1]][puddle[0]] = -1;
        }
        
        count[1][1] = 1;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                if (count[x][y] == -1) continue;
                int c = 0;
                for (int i = 0; i < 2; i++) {
                    int nx = x + DX[i];
                    int ny = y + DY[i];
                    if (count[nx][ny] > 0) c += count[nx][ny];
                }
                count[x][y] += c % 1000000007;
            }
        }
        
        return count[n][m];
    }
}