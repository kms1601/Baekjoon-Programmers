import java.io.*;
import java.util.*;

public class Main {
    static int count = 1;

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
            nodes[p].next.add(-q);
            nodes[q].next.add(-p);
        }

        Arrays.stream(dfs(R, nodes, new boolean[N], new int[N])).forEach(System.out::println);
    }

    private static int[] dfs(int p, Node[] nodes, boolean[] visit, int[] result) {
        result[p - 1] = count++;
        visit[p - 1] = true;
        for (int next : nodes[p].next) {
            next = -next;
            if (visit[next - 1]) continue;
            dfs(next, nodes, visit, result);
        }
        return result;
    }
}
