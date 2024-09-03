class Solution {
    final int[][] comb = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
    
    public int solution(int[][] dots) {
        for (int[] com : comb) {
            int[] a = dots[com[0]];
            int[] b = dots[com[1]];
            int[] c = dots[com[2]];
            int[] d = dots[com[3]];
            
            if (getSlope(a, b) == getSlope(c, d)) {
                return 1;
            }
        }
        return 0;
    }
    
    private double getSlope(int[] a, int[] b) {
        return ((double) a[1] - b[1]) / (a[0] - b[0]);
    }
}