import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;
    private static List<List<Integer>> vertexes = new ArrayList<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(BR.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] nums = new long[N + 1];
        st = new StringTokenizer(BR.readLine());
        vertexes.add(null);
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            vertexes.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(BR.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            vertexes.get(p).add(q);
            vertexes.get(q).add(p);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(BR.readLine());
            List<Integer> solved = solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            StringBuilder sb = new StringBuilder();
            solved.forEach((e) -> sb.append(nums[e]));
            BigInteger result = new BigInteger(sb.toString());
            result = result.mod(new BigInteger("1000000007"));
            System.out.println(result);
        }
    }

    private static List<Integer> solve(int x, int y) {
        Deque<List<Integer>> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        List<Integer> init = new ArrayList<>();
        init.add(x);
        queue.add(init);
        visit[x] = true;

        if (x == y) return init;

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            for (int next : vertexes.get(cur.get(cur.size() - 1))) {
                if (visit[next]) continue;

                if (next == y) {
                    cur.add(next);
                    return cur;
                }

                List<Integer> clone = new ArrayList<>(cur);
                clone.add(next);
                queue.add(clone);
                visit[next] = true;
            }
        }
        return new ArrayList<>();
    }
}
