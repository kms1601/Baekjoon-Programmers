import java.util.*;

class Solution {
    final int[][] comb = {{0, 1, 2}, {1, 0, 2}, {2, 0, 1}};
    
    public int solution(int[][] lines) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < 3; i++) {
            int[] a = lines[comb[i][0]];
            int[] b = lines[comb[i][1]];
            int[] c = lines[comb[i][2]];
            
            for (int j = a[0]; j < a[1]; j++) {
                if ((between(j, b) || between(j, c)) && !set.contains(j)) {
                    answer++;
                    set.add(j);
                }
            }
        }
        
        return answer;
    }
    
    private boolean between(int a, int[] b) {
        return b[0] <= a && a < b[1];
    }
}