import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DH = {1, -1, 0, 0, 1, 1, -1, -1};
    private static final int[] DW = {0, 0, 1, -1, 1, -1, 1, -1};

    private static int W;
    private static int H;
    private static int count;
    private static String[] field;
    private static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        String[] input = BR.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);
        field = new String[H];

        for (int h = 0; h < H; h++) {
            field[h] = BR.readLine();
        }

        visit = new boolean[H][W];
        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (field[h].charAt(w) == '.' && !visit[h][w]) {
                    count = 1;
                    dfs(h, w);
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }

    private static void dfs(int h, int w) {
        visit[h][w] = true;
        for (int i = 0; i < 8; i++) {
            int nh = h + DH[i];
            int nw = w + DW[i];
            if (0 <= nh && nh < H && 0 <= nw && nw < W && field[nh].charAt(nw) == '.' && !visit[nh][nw]) {
                count++;
                dfs(nh, nw);
            }
        }
    }
}
