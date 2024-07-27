import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[col - 1] != b[col - 1]) return Integer.compare(a[col - 1], b[col - 1]);
                return Integer.compare(b[0], a[0]);
            }
        });
        
        int answer = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int mod = 0;
            for (int e : data[i]) {
                mod += e % (i + 1);
            }
            answer ^= mod;
        }
        return answer;
    }
}