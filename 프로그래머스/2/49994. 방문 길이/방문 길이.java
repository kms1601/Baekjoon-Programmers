import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0;
        Set<String> visit = new HashSet<>();
        int[] move = {1, 0};
        for (char dir : dirs.toCharArray()) {
            setMove(dir, move);
            int nx = Math.max(Math.min(x + move[0], 5), -5);
            int ny = Math.max(Math.min(y + move[1], 5), -5);
            if (nx == x && ny == y) continue;
            if (dir == 'U' || dir == 'R') {
                visit.add(String.format("%d%d %d%d", x, y, nx, ny));
            } else {
                visit.add(String.format("%d%d %d%d", nx, ny, x, y));
            }
            x = nx;
            y = ny;
        }
        return visit.size();
    }
            
    private void setMove(char dir, int[] move) {
        switch (dir) {
            case 'U':
                move[0] = 1;
                move[1] = 0;
                break;
            case 'D':
                move[0] = -1;
                move[1] = 0;
                break;
            case 'R':
                move[0] = 0;
                move[1] = 1;
                break;
            case 'L':
                move[0] = 0;
                move[1] = -1;
                    
        }
    }
}