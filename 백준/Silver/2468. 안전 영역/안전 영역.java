import java.io.*;
import java.util.*;

public class Main {
    static final int[] DX = new int[]{1, -1, 0, 0};
    static final int[] DY = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] height = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i <= 100; i++) {
            boolean[][] visit = new boolean[N][N];
            int safe = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visit[j][k] && height[j][k] > i) {
                        safe++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{j, k});
                        visit[j][k] = true;
                        while(!queue.isEmpty()) {
                            int[] now = queue.remove();
                            int x = now[0], y = now[1];

                            for (int l = 0; l < 4; l++) {
                                int dx = x + DX[l], dy = y + DY[l];
                                if (
                                        0 <= dx && dx < N &&
                                        0 <= dy && dy < N &&
                                        height[dx][dy] > i &&
                                        !visit[dx][dy]) {
                                    queue.add(new int[]{dx, dy});
                                    visit[dx][dy] = true;
                                }
                            }
                        }
                    }
                }
            }
            if (safe > max) {
                max = safe;
            }
        }
        System.out.println(max);
    }
}
