import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;
    private static int N;
    private static int[][] preference;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(BR.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        preference = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(BR.readLine());
            for (int m = 0; m < M; m++) {
                preference[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    max = Math.max(max, sum(i, j, k));
                }
            }
        }
        System.out.println(max);
    }

    private static int sum(int i, int j, int k) {
        int result = 0;
        for (int n = 0; n < N; n++) {
            result += Math.max(preference[n][i], Math.max(preference[n][j], preference[n][k]));
        }
        return result;
    }
}
