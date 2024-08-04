import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] question = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> relations = new HashMap<>();
        for (int i = 0; i < n; i++) {
            relations.put(i + 1, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int child = Integer.parseInt(s[0]);
            int parent = Integer.parseInt(s[1]);

            relations.get(child).add(parent);
            relations.get(parent).add(child);
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(new int[]{Integer.parseInt(question[0]), 0});
        int answer = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int me = now[0];
            int count = now[1];

            visit[me] = true;

            if (now[0] == Integer.parseInt(question[1])) {
                answer = count;
                break;
            }

            for (int i : relations.getOrDefault(me,  Collections.emptyList())) {
                if (!visit[i]) {
                    queue.add(new int[]{i, count + 1});
                }
            }
        }
        System.out.println(answer);
    }
}
