import java.io.*;
import java.util.*;

public class Main {
    static int[] DH = {1, -1, 0, 0, -1, 1, 1, -1, 0, 0, -1, 1};
    static int[] DW = {0, 0, 1, -1, -1, -1, 0, 0, 1, -1, 1, 1};
    static int H;
    static int W;
    static int[][] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        house = new int[H + 2][W + 2];
        for (int h = 1; h <= H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 1; w <= W; w++) {
                if (st.nextToken().equals("1")) {
                    house[h][w] = 1;
                }
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int h, int w) {
        int result = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{h, w});
        house[h][w] = 2;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0] % 2 == 0 ? 0 : 6;
            for (int j = 0; j < 6; j++) {
                int dh = cur[0] + DH[i + j];
                int dw = cur[1] + DW[i + j];
                if (0 <= dh && dh <= H + 1 && 0 <= dw && dw <= W + 1) {
                    if (house[dh][dw] == 0) {
                        queue.add(new int[]{dh, dw});
                        house[dh][dw] = 2;
                    } else if (house[dh][dw] == 1) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
