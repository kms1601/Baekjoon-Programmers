import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<int[]> queue = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int inp = Integer.parseInt(st.nextToken());
                if (inp == 1) {
                    inp = -1;
                } else if (inp == 2) {
                    queue.add(new int[]{i, j, 0});
                    inp = 0;
                }
                map[i][j] = inp;
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == -1) {
                    map[nx][ny] = now[2] + 1;
                    queue.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        for (int[] i : map) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }
}
