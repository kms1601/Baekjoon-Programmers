import java.io.*;

public class Main {
    private static int N;
    private static int[][] dominoes;
    private static boolean[] col;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        dominoes = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = input.charAt(j);
                if ('A' <= c && c <= 'I') {
                    dominoes[i][j] = '@' - c;
                } else {
                    dominoes[i][j] = c - '0';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            choose(new int[N], 0, i);
        }

        System.out.println(min);
        System.out.println(max);
    }

    private static void choose(int[] result, int r, int c) {
        result[r] = c;
        col[c] = true;

        if (r == N - 1) {
            int score = (countCycle(result) % 2 == 0 ? -1 : 1) * getScore(result);
            min = Math.min(min, score);
            max = Math.max(max, score);
        } else {
            for (int i = 0; i < N; i++) {
                if (col[i]) continue;
                choose(result, r + 1, i);
            }
        }

        result[r] = 0;
        col[c] = false;
    }

    private static int countCycle(int[] arr) {
        boolean[] visit = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            count++;
            int cur = i;
            while (!visit[cur]) {
                visit[cur] = true;
                cur = arr[cur];
            }
        }
        return count;
    }

    private static int getScore(int[] arr) {
        int result = 1;
        for (int i = 0; i < N; i++) {
            result *= dominoes[i][arr[i]];
        }
        return result;
    }
}
