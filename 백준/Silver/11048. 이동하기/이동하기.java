import java.io.*;
import java.util.*;

public class Main {
    static final int[] DN = {-1, 0, -1};
    static final int[] DM = {-1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maxCandy = new int[N + 1][M + 1];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                int max = 0;
                for (int i = 0; i < 3; i++) {
                    int dn = n + DN[i];
                    int dm = m + DM[i];
                    max = Math.max(max, maxCandy[dn][dm]);
                }
                maxCandy[n][m] = max + Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(maxCandy[N][M]);
    }
}
