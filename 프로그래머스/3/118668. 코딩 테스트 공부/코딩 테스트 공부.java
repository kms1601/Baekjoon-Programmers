import java.util.*;

class Solution {
    private final int INF = 1_000_000_000;
    
    public int solution(int alp, int cop, int[][] problems) {
        int trtAlp = alp, trtCop = cop;
        for (int[] problem : problems) {
            trtAlp = Math.max(trtAlp, problem[0]);
            trtCop = Math.max(trtCop, problem[1]);
        }
        
        int[][] costs = new int[trtAlp + 1][trtCop + 1];
        
        for (int i = 0; i <= trtAlp; i++) {
            Arrays.fill(costs[i], INF);
        }
        
        costs[alp][cop] = 0;
        
        for (int a = 0; a <= trtAlp; a++) {
            for (int c = 0; c <= trtCop; c++) {
                if (costs[a][c] == INF) continue;
                
                for (int[] problem : problems) {
                    if (a < problem[0] || c < problem[1]) continue;
                    
                    int na = Math.min(trtAlp, a + problem[2]);
                    int nc = Math.min(trtCop, c + problem[3]);
                    costs[na][nc] = Math.min(costs[na][nc], costs[a][c] + problem[4]);
                }
                
                if (a != trtAlp) costs[a + 1][c] = Math.min(costs[a + 1][c], costs[a][c] + 1);
                if (c != trtCop) costs[a][c + 1] = Math.min(costs[a][c + 1], costs[a][c] + 1);
            }
        }
        
        return costs[trtAlp][trtCop];
    }
}