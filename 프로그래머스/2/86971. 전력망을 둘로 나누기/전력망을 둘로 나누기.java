import java.util.*;

class Solution {
    private List<Set<Integer>> edges = new ArrayList<>();
    private int n;
    private boolean[] visit;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            edges.add(new HashSet<>());
        }
        
        for (int[] wire : wires) {
            int p = wire[0] - 1;
            int q = wire[1] - 1;
            edges.get(p).add(q);
            edges.get(q).add(p); 
        }
        
        int min = 98;
        for (int[] wire : wires) {
            int p = wire[0] - 1;
            int q = wire[1] - 1;
            edges.get(p).remove(q);
            edges.get(q).remove(p);
            min = Math.min(min, getDiff());
            edges.get(p).add(q);
            edges.get(q).add(p);
        }
        return min;
    }
    
    private int getDiff() {
        visit = new boolean[n];
        int a = dfs(0);
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            b = dfs(i);
            break;
        }
        return Math.abs(a - b);
    }
    
    private int dfs(int n) {
        visit[n] = true;
        int count = 1;
        for (int next : edges.get(n)) {
            if (visit[next]) continue;
            count += dfs(next);
        }
        return count;
    }
}