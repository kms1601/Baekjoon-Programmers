import java.io.*;
import java.util.*;

public class Main {
    private static int[] DR = {1, -1, 0, 0, 1, 1, -1, -1};
    private static int[] DC = {0, 0, 1, -1, 1, -1, 1, -1};

    private static int M;
    private static int N;
    private static int[][] banner;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        banner = new int[M][N];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                banner[m][n] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (banner[m][n] == 1) {
                    answer++;
                    setText(m, n);
                }
            }
        }
        System.out.println(answer);
    }

    private static void setText(int r, int c) {
        banner[r][c] = 2;
        for (int i = 0; i < 8; i++) {
            int nr = r + DR[i];
            int nc = c + DC[i];
            if (0 <= nr && nr < M && 0 <= nc && nc < N && banner[nr][nc] == 1) {
                setText(nr, nc);
            }
        }
    }
}
