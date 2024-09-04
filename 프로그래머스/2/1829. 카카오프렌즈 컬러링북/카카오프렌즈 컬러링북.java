import java.util.*;

class Solution {
    private final int[] DR = {1, -1, 0, 0};
    private final int[] DC = {0, 0, 1, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visit = new boolean[m][n];
        int[] answer = new int[2];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visit[i][j]) continue;
                int val = picture[i][j];
                int area = 0;
                count++;
                Deque<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});
                visit[i][j] = true;
                while (!queue.isEmpty()) {
                    area++;
                    int[] cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ni = cur[0] + DR[k];
                        int nj = cur[1] + DC[k];
                        if (0 <= ni && ni < m && 0 <= nj && nj < n && picture[ni][nj] == val && !visit[ni][nj]) {
                            queue.add(new int[]{ni, nj});
                            visit[ni][nj] = true;
}
                    }
                }
                answer[1] = Math.max(answer[1], area);
            }
        }
        answer[0] = count;
        return answer;
    }
}