import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visit = new boolean[n];
        Deque<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            queue.offer(i);
            visit[i] = true;
            count++;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next = 0; next < n; next++) {
                    if (computers[cur][next] == 0 || visit[next]) continue;
                    queue.offer(next);
                    visit[next] = true;
                }
            }
        }
        return count;
    }
}