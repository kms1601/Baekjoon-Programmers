import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] DR = {0, -1, 0, 1, 0};
    private static final int[] DC = {0, 0, 1, 0, -1};
    private static final char[] dirName = {'0', 'U', 'R', 'D', 'L'};

    private static int N;
    private static int M;

    private static String[] space;

    public static void main(String[] args) throws IOException {
        String[] input = BR.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        space = new String[N];
        for (int i = 0; i < N; i++) {
            space[i] = BR.readLine();
        }

        input = BR.readLine().split(" ");
        int PR = Integer.parseInt(input[0]) - 1;
        int PC = Integer.parseInt(input[1]) - 1;
        char dirMax = ' ';
        int moveMax = 0;
        for (int i = 1; i <= 4; i++) {
            int move = move(PR, PC, i, new int[N][M]);
            if (moveMax < move) {
                dirMax = dirName[i];
                moveMax = move;
            }
        }
        System.out.println(dirMax);
        System.out.println(moveMax == Integer.MAX_VALUE ? "Voyager" : moveMax);
    }

    private static int move(int r, int c, int dir, int[][] visit) {
        int time = 1;
        while (true) {
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            if (0 > nr || nr >= N) return time;
            if (0 > nc || nc >= M) return time;

            if (visit[nr][nc] == dir) return Integer.MAX_VALUE;
            visit[nr][nc] = dir;

            switch (space[nr].charAt(nc)) {
                case 'C':
                    return time;
                case '/':
                    switch (dir) {
                        case 1:
                            dir = 2;
                            break;
                        case 2:
                            dir = 1;
                            break;
                        case 3:
                            dir = 4;
                            break;
                        case 4:
                            dir = 3;
                    }
                    break;
                case '\\':
                    switch (dir) {
                        case 1:
                            dir = 4;
                            break;
                        case 2:
                            dir = 3;
                            break;
                        case 3:
                            dir = 2;
                            break;
                        case 4:
                            dir = 1;
                    }
            }
            r = nr;
            c = nc;
            time++;
        }
    }
}
