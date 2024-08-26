import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] dominoes;
    private static Set<Integer> row = new HashSet<>();
    private static Set<Integer> col = new HashSet<>();
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


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
            choose(new ArrayList<>(), i, 0);
        }

        System.out.println(min);
        System.out.println(max);
    }

    private static void choose(List<int[]> result, int r, int c) {
        result.add(new int[]{r, c});
        row.add(r);
        col.add(c);

        if (result.size() == N) {
            List<int[]> sorted = new ArrayList<>(result);
            sorted.sort(Comparator.comparingInt(a -> a[0]));
            int score = (countCycle(sorted) % 2 == 0 ? -1 : 1) * getScore(result);
            min = Math.min(min, score);
            max = Math.max(max, score);
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (row.contains(i) || col.contains(j)) continue;
                    choose(result, i, j);
                }
            }
        }

        result.remove(result.size() - 1);
        row.remove(r);
        col.remove(c);
    }

    private static int countCycle(List<int[]> list) {
        boolean[] visit = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            count++;
            int cur = i;
            while (!visit[cur]) {
                visit[cur] = true;
                cur = list.get(cur)[1];
            }
        }
        return count;
    }

    private static int getScore(List<int[]> list) {
        int result = 1;
        for (int[] cur : list) {
            result *= dominoes[cur[0]][cur[1]];
        }
        return result;
    }
}
