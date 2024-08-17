class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long x1 = x, x2 = x;
        long y1 = y, y2 = y;
        
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            switch (query[0]) {
                case 0:
                    if (y1 != 0) {
                        y1 += query[1];
                        if (y1 >= m) return 0;
                    }
                    y2 += query[1];
                    y2 = y2 >= m ? m - 1 : y2;
                    break;
                case 1:
                    if (y2 != m - 1) {
                        y2 -= query[1];
                        if (y2 < 0) return 0;
                    }
                    y1 -= query[1];
                    y1 = y1 < 0 ? 0 : y1;
                    break;
                case 2:
                    if (x1 != 0) {
                        x1 += query[1];
                        if (x1 >= n) return 0;
                    }
                    x2 += query[1];
                    x2 = x2 >= n ? n - 1 : x2;
                    break;
                case 3:
                    if (x2 != n - 1) {
                        x2 -= query[1];
                        if (x2 < 0) return 0;
                    } 
                    x1 -= query[1];
                    x1 = x1 < 0 ? 0 : x1;
            }
        }
        
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}