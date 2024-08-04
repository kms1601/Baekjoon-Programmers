import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Set<Integer> next = new TreeSet<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N + 1];
        for (int n = 1; n <= N; n++) nodes[n] = new Node();

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            nodes[p].next.add(q);
            nodes[q].next.add(p);
        }

        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[N];
        boolean[] visit = new boolean[N];
        int count = 1;

        q.offer(R);
        visit[R - 1] = true;
        result[R - 1] = count;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : nodes[cur].next) {
                if (visit[next - 1]) continue;
                q.offer(next);
                visit[next - 1] = true;
                result[next - 1] = ++count;
            }
        }
        Arrays.stream(result).forEach(System.out::println);
    }
}
