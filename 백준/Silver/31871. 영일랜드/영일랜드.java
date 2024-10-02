import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int max = -1;
    private static StringTokenizer st;
    private static boolean[] visit;
    private static int[][] park;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(BR.readLine());
        park = new int[N + 1][N + 1];
        int M = Integer.parseInt(BR.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(BR.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (u == v) continue;
            park[u][v] = Math.max(park[u][v], d);
        }

        visit = new boolean[N + 1];
        findMax(0, 0, 0);
        System.out.println(max);
    }

    private static void findMax(int cur, int sum, int count) {
        if (count == N) {
            if (park[cur][0] > 0) {
                max = Math.max(max, sum + park[cur][0]);
            }
            return;
        }

        for (int next = 1; next <= N; next++) {
            if (visit[next] || park[cur][next] == 0) continue;
            visit[next] = true;
            findMax(next, sum + park[cur][next], count + 1);
            visit[next] = false;
        }
    }
}
