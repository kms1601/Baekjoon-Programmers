import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stones = new int[n];
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        int init = Integer.parseInt(br.readLine()) - 1;
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(init);
        visit[init] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answer++;

            int[] nextArr = new int[2];
            nextArr[0] = cur + stones[cur];
            nextArr[1] = cur - stones[cur];
            for (int next : nextArr) {
                if (0 <= next && next < n && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
