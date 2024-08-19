import java.io.*;
import java.util.*;

public class Main {
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};

    private static int R;
    private static int C;
    private static String[] board;
    private static boolean[][] visit;
    private static int max = 1;
    private static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        board = new String[R];
        for (int r = 0; r < R; r++) {
            board[r] = br.readLine();
        }

        visit = new boolean[R][C];
        set.add(board[0].charAt(0));
        visit[0][0] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int r, int c, int move) {
        max = Math.max(max, move);

        for (int i = 0; i < 4; i++) {
            int nr = r + DR[i];
            int nc = c + DC[i];
            if (0 > nr || nr >= R || 0 > nc || nc >= C) continue;
            char ch = board[nr].charAt(nc);
            if (visit[nr][nc] || set.contains(ch)) continue;
            set.add(ch);
            visit[nr][nc] = true;
            dfs(nr, nc, move + 1);
            set.remove(ch);
            visit[nr][nc] = false;
        }
    }
}
