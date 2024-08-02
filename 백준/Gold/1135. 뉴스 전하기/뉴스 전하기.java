import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> company = new ArrayList<>();
        int[] link = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int n = 0; n < N; n++) {
            List<Integer> list = new ArrayList<>();
            company.add(list);
            for (int i = 0; i < N; i++)
                if (link[i] == n) list.add(i);
        }

        int[][] times = new int[N][2];
        dfs(company, times, 0, 0);
        Arrays.sort(times, (a, b) -> Integer.compare(b[0], a[0]));
        int[] maxTime = new int[N];
        for (int[] from : times) {
            List<Integer> to = company.get(from[1]);
            if (to.isEmpty()) continue;
            List<Integer> timeList = new ArrayList<>();
            for (int i : to)
                timeList.add(maxTime[i]);

            timeList.sort(Collections.reverseOrder());
            int max = 0;
            int count = 1;
            for (int time : timeList) {
                max = Math.max(max, time + count);
                count++;
            }
            maxTime[from[1]] = max;
        }
        System.out.println(maxTime[0]);
    }

    private static void dfs(List<List<Integer>> company, int[][] times, int cur, int time) {
        for (int i : company.get(cur)) {
            times[i][0] = time + 1;
            times[i][1] = i;
            dfs(company, times, i, time + 1);
        }
    }
}
