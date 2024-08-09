class Solution {
    private String name;
    private int n;
    private final int[] alpha = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    
    public int solution(String name) {
        this.name = name;
        this.n = name.length();
        
        int move = 0;
        int cursor = n - 1;
        for (int i = 0; i < n; i++) {
            move += alpha[name.charAt(i) - 'A'];
            cursor = Math.min(cursor, moveCursor(i));
        }
        
        return move + cursor;
    }
    
    private int moveCursor(int i) {
        int j = i + 1;
        for (; j < n; j++) {
            if (name.charAt(j) != 'A') break;
        }
        
        j = n - j;
        
        return Math.min(i * 2 + j, j * 2 + i);
    }
}