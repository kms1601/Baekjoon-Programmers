import java.util.*;

class Solution {
    final int[] DX = {1, -1, 0, 0, 1, 1, -1, -1};
    final int[] DY = {0, 0, 1, -1, 1, -1, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        int[][] map = new int[104][104];
        for (int[] rect : rectangle) {
            for (int x = rect[0] * 2; x <= rect[2] * 2; x++) {
                for (int y = rect[1] * 2; y <= rect[3] * 2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        map[0][0] = 2;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + DX[i];
                int ny = cur[1] + DY[i];
                if (0 > nx || nx > 103 || 0 > ny || ny > 103 || map[nx][ny] >= 2) continue;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 3;
                    continue;
                }
                queue.add(new int[]{nx, ny});
                map[nx][ny] = 2;
            }
        }
        
        int answer = 0;
        queue.add(new int[]{characterX, characterY, 0});
        map[characterX][characterY] = 4;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == itemX && cur[1] == itemY) {
                answer = cur[2];
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + DX[i];
                int ny = cur[1] + DY[i];
                if (map[nx][ny] != 3) continue;
                queue.add(new int[]{nx, ny, cur[2] + 1});
                map[nx][ny] = 4;
            }
        }
        
        return answer / 2;
    }
}