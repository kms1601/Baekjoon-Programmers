import java.util.*;

class Solution { 
    public int solution(int n, int[][] vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] v : vertex) {
            int p = v[0];
            int q = v[1];
            graph.get(p).add(q);
            graph.get(q).add(p);
        }
        
        int answer = 0;
        int max = 0;
        boolean[] visit = new boolean[n + 1];
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visit[1] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[1] > max) {
                max = cur[1];
                answer = 1;
            } else if (cur[1] == max) {
                answer++;
            }
            
            for (int next : graph.get(cur[0])) {
                if (visit[next]) continue;
                queue.add(new int[]{next, cur[1] + 1});
                visit[next] = true;
            }
        }
        return answer;
    }
}