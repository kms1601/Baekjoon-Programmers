import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};

    private static int N;
    private static int M;
    private static StringBuilder[] map;

    public static void main(String[] args) throws IOException {
        String[] input = BR.readLine().split( " ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new StringBuilder[M];
        for (int i = 0; i < M; i++) {
            map[i] = new StringBuilder(BR.readLine());
        }

        int[] power = new int[2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char team = map[i].charAt(j);
                int result = bfs(i, j, team);
                if (team == 'W') {
                    power[0] += result * result;
                } else if (team == 'B') {
                    power[1] += result * result;
                }
            }
        }

        System.out.printf("%d %d", power[0], power[1]);
    }

    private static int bfs(int r, int c, char team) {
        int result = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        if (team != '.') {
            queue.offer(new int[]{r, c});
            map[r].setCharAt(c, '.');
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            result++;
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + DR[i];
                int nc = cur[1] + DC[i];
                if (0 <= nr && nr < M && 0 <= nc && nc < N && map[nr].charAt(nc) == team) {
                    map[nr].setCharAt(nc, '.');
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return result;
    }
}
