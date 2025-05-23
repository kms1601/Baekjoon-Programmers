import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(BR.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] camping = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(BR.readLine());
            for (int m = 0; m < M; m++) {
                camping[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dig = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(BR.readLine());
            for (int c = 0; c < C; c++) {
                dig[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int n = 0; n < N - R + 1; n++) {
            for (int m = 0; m < M - C + 1; m++) {
                boolean flag = true;
                int height = camping[n][m] - dig[0][0];
                loop:
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (camping[n + r][m + c] - dig[r][c] != height) {
                            flag = false;
                            break loop;
                        }
                    }
                }

                if (flag) answer++;
            }
        }
        System.out.println(answer);
    }
}
