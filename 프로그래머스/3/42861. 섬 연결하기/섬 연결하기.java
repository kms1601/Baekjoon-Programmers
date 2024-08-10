import java.util.*;

class Solution {
    private int[] parents;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        parents = new int[n];
        Arrays.setAll(parents, (i) -> i);
        
        int answer = 0;
        for (int[] cost : costs) {
            if (find(cost[0]) == find(cost[1])) continue;
            union(cost[0], cost[1]);
            answer += cost[2];
        }
        return answer;
    }
    
        
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parents[y] = x;
    }
    
    private int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}