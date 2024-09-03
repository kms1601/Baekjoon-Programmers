import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int N = score.length;
        List<int[]> sum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sum.add(new int[]{score[i][0] + score[i][1], i});
        }
        
        sum.sort(Comparator.comparingInt((e) -> -e[0]));
        
        int[] answer = new int[N];
        int grade = 1;
        int count = 0;
        int before = sum.get(0)[0];
        for (int[] s : sum) {
            if (before == s[0]) {
                count++;
            } else {
                before = s[0];
                grade += count;
                count = 1;
            }
            answer[s[1]] = grade;
        }
        return answer;
    }
}