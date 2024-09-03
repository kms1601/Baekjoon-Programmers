class Solution {
    public int solution(int[][] dots) {
        int x1 = 256, x2 = -256;
        int y1 = 256, y2 = -256;
        
        for (int[] dot : dots) {
            x1 = Math.min(x1, dot[0]);
            y1 = Math.min(y1, dot[1]);
            x2 = Math.max(x2, dot[0]);
            y2 = Math.max(y2, dot[1]);
        }
        
        return (x2 - x1) * (y2 - y1);
    }
}