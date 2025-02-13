class Solution {
    public int solution(int[] mats, String[][] park) {
        int max = 0;
        for (int r = 0; r < park.length; r++) {
            for (int c = 0; c < park[0].length; c++) {
                max = Math.max(max, getMaxSize(r, c, park));
            }
        }
        
        int answer = -1;
        for (int mat : mats) {
            if (answer < mat && mat <= max) {
                answer = mat;
            }
        }
        return answer;
    }
    
    private int getMaxSize(int r, int c, String[][] park) {
        int max = 1;
        loop :
        while ((max + r - 1 < park.length) && (max + c - 1 < park[0].length)) {
            for (int i = 0; i < max; i++) {
                if (!(park[r + i][max + c - 1].equals("-1") && park[max + r - 1][c + i].equals("-1"))) {
                    break loop;
                }
            }
            max++;
        }
        return max - 1;
    }
}