import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DX = {1, -1, 0, 0, 1, 1, -1, -1};
    private static final int[] DY = {0, 0, 1, -1, 1, -1, 1, -1};

    private static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[][] farm;
    private static boolean[][] visit;
    private static List<FarmSet> farmSetList = new ArrayList<>();

    static class FarmSet {
        private int height;
        public List<int[]> set = new ArrayList<>();

        public FarmSet(int height) {
            this.height = height;
        }

        public boolean isPeak() {
            for (int[] pos : set) {
                for (int i = 0; i < 8; i++) {
                    int nx = pos[0] + DX[i];
                    int ny = pos[1] + DY[i];
                    if (!isValid(nx, ny)) continue;
                    if (farm[nx][ny] > height) return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(BR.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        farm = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(BR.readLine());
            for (int m = 0; m < M; m++) {
                farm[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (!visit[n][m]) farmSetList.add(getFarmSet(n, m, new FarmSet(farm[n][m])));
            }
        }

        System.out.println(farmSetList.stream().filter(FarmSet::isPeak).count());
    }

    private static FarmSet getFarmSet(int x, int y, FarmSet fs) {
        fs.set.add(new int[]{x, y});
        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if (!isValid(nx, ny) || farm[nx][ny] != fs.height || visit[nx][ny]) continue;
            getFarmSet(nx, ny, fs);
        }
        return fs;
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
