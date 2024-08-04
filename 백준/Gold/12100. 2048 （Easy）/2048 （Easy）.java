import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] game = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] moves = new int[5];
        int max = 0;
        for (int i = 0; i < 1024; i++) {
            max = Math.max(max, getMaxBlock(moves, game, N));

            for (int j = 0; j < 5; j++) {
                moves[j]++;
                if (moves[j] != 4) break;
                moves[j] = 0;
            }
        }
        System.out.println(max);
    }

    private static int getMaxBlock(int[] moves, int[][] game, int N) {
        int[][] clone = getClone(game);
        for (int q = 0; q < 5; q++) {
            boolean[][] merged = new boolean[N][N];
            int move = moves[q];
            switch (move) {
                case 0: // up
                    for (int j = 0; j < N; j++) {
                        for (int i = 1; i < N; i++) {
                            if (clone[i][j] == 0) continue;

                            int r = i;
                            do {
                                r--;
                            } while (!(r < 0 || clone[r][j] != 0));

                            if (r != -1 && !merged[r][j] && clone[r][j] == clone[i][j]) {
                                clone[r][j] *= 2;
                                clone[i][j] = 0;
                                merged[r][j] = true;
                            } else {
                                clone[r + 1][j] = clone[i][j];
                                if (r + 1 != i) clone[i][j] = 0;
                            }
                        }
                    }
                    break;
                case 1: // right
                    for (int i = 0; i < N; i++) {
                        for (int j = N - 2; j >= 0; j--) {
                            if (clone[i][j] == 0) continue;

                            int c = j;
                            do {
                                c++;
                            } while (!(c >= N || clone[i][c] != 0));

                            if (c != N && !merged[i][c] && clone[i][c] == clone[i][j]) {
                                clone[i][c] *= 2;
                                clone[i][j] = 0;
                                merged[i][c] = true;
                            } else {
                                clone[i][c - 1] = clone[i][j];
                                if (c - 1 != j) clone[i][j] = 0;
                            }
                        }
                    }
                    break;
                case 2: // down
                    for (int j = 0; j < N; j++) {
                        for (int i = N - 2; i >= 0; i--) {
                            if (clone[i][j] == 0) continue;

                            int r = i;
                            do {
                                r++;
                            } while (!(r >= N || clone[r][j] != 0));

                            if (r != N && !merged[r][j] && clone[r][j] == clone[i][j]) {
                                clone[r][j] *= 2;
                                clone[i][j] = 0;
                                merged[r][j] = true;
                            } else {
                                clone[r - 1][j] = clone[i][j];
                                if (r - 1 != i) clone[i][j] = 0;
                            }
                        }
                    }
                    break;
                case 3: // left
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (clone[i][j] == 0) continue;

                            int c = j;
                            do {
                                c--;
                            } while (!(c < 0 || clone[i][c] != 0));

                            if (c != -1 && !merged[i][c] && clone[i][c] == clone[i][j]) {
                                clone[i][c] *= 2;
                                clone[i][j] = 0;
                                merged[i][c] = true;
                            } else {
                                clone[i][c + 1] = clone[i][j];
                                if (c + 1 != j) clone[i][j] = 0;
                            }
                        }
                    }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, clone[i][j]);
            }
        }
        return max;
    }

    private static int[][] getClone(int[][] arr) {
        int[][] clone = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                clone[i][j] = arr[i][j];
            }
        }
        return clone;
    }
}
