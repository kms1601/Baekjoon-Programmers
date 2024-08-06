class Solution {    
    private int count = 0;
    private int n;
    
    public int solution(int n) {
        this.n = n;
        NQueen(new int[n][n], 0);
        return count;
    }
    
    private void NQueen(int[][] board, int r) {
        if (r == n) {
            count++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (board[r][i] > 0) {
                continue;
            }
            setSafe(board, 1, r, i);
            NQueen(board, r + 1);
            setSafe(board, -1, r, i);
        }
    }
    
    private void setSafe(int[][] board, int val, int r, int c) {
        for (int dc = -1; dc <= 1; dc++) {
            int tr = r;
            int tc = c;
            while(0 <= tr && tr < n && 0 <= tc && tc < n) {
                board[tr][tc] += val;
                tr++;
                tc += dc;
            }
        }
    }
}