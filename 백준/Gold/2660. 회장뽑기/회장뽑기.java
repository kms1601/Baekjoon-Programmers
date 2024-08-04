import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> friends = new ArrayList<>();
        int[] scores = new int[N + 1];
        for (int n = 0; n <= N; n++) friends.add(new ArrayList<>());
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (u == -1) break;
            friends.get(u).add(v);
            friends.get(v).add(u);
        }

        int min = 51;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            Queue<int[]> q = new LinkedList<>();
            boolean[] visit = new boolean[N + 1];
            q.offer(new int[]{i, 0});
            visit[i] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                max = Math.max(max, cur[1]);
                for (int next : friends.get(cur[0])) {
                    if (visit[next]) continue;
                    q.offer(new int[]{next, cur[1] + 1});
                    visit[next] = true;
                }
            }
            scores[i] = max;
            min = Math.min(min, max);
        }

        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            if (scores[i] == min) candidate.add(i);
        System.out.println(min + " " + candidate.size());
        candidate.forEach((i) -> System.out.print(i + " "));
    }
}
