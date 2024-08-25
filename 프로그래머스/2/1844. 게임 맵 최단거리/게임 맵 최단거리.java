import java.util.*;

class Solution {
    private final int[] DR = {1, -1, 0, 0};
    private final int[] DC = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        maps[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) return cur[2];
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + DR[i];
                int nc = cur[1] + DC[i];
                if (0 > nr || nr >= n || 0 > nc || nc >= m || maps[nr][nc] == 0) continue;
                queue.add(new int[]{nr, nc, cur[2] + 1});
                maps[nr][nc] = 0;
            }
        }
        
        return -1;
    }
}