import java.util.*;

class Solution {
    int[][] computers;
    int n;
    boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visit = new boolean[n];
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int i) {
        visit[i] = true;
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1 && !visit[j]) dfs(j);
        }
    }
}