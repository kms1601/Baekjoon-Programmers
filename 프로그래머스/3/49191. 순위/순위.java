import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] table = new int[n][n];
        int answer = 0;
        for (int[] result : results) {
            table[result[0] - 1][result[1] - 1] = 1;
            table[result[1] - 1][result[0] - 1] = -1;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][k] == 1 && table[k][j] == 1) {
                        table[i][j] = 1;
                    } else if (table[i][k] == -1 && table[k][j] == -1) {
                        table[i][j] = -1;
                    }
                }
            }
        }
        
        for (int[] row : table) {
            if (Arrays.stream(row).filter((i) -> i != 0).count() == n - 1)
                answer++;   
        }
        return answer;
    }
}