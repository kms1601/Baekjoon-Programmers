class Solution {
    private final int[] winCase = {7, 56, 73, 84, 146, 273, 292, 448};
    
    public int solution(String[] board) {
        int o = getCount(board, 'O');
        int x = getCount(board, 'X');
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');
        
        if (o < x) return 0;
        if (o > x + 1) return 0;
        if (oWin && xWin) return 0;
        if (oWin && o != x + 1) return 0;
        if (xWin && o != x) return 0;
        return 1;
    }
    
    private int toBit(String[] board, char ox) {
        int bit = 0;
        int val = 1;
        for (String str : board) {
            for (char c : str.toCharArray()) {
                if (c == ox) bit += val;
                val *= 2;
            }
        }
        return bit;
    }
    
    private boolean isWin(String[] board, char ox) {
        int bit = toBit(board, ox);
        for (int w : winCase) {
            if ((bit & w) == w) {
                return true;
            }
        }
        return false;
    }
    
    private int getCount(String[] board, char ox) {
        int count = 0;
        for (String str : board) {
            for (char c : str.toCharArray()) {
                if (c == ox) count++;
            }
        }
        return count;
    }
}