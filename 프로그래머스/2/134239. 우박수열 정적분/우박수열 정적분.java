import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> seq = seq(k);
        int max = seq.size() - 1;
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            if (a == 0 && b == 0) {
                answer[i] = seq.get(max) / 2.0;
            } else {
                if (a > b + max) {
                    answer[i] = -1.0;
                } else {
                    answer[i] = (seq.get(b + max) - seq.get(a)) / 2.0;
                }
            }
        }
        System.out.println(seq(k));
        return answer;
    }
    
    private List<Integer> seq(int k) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int prev = k;
        int cur = next(k);
        result.add(prev + cur);
        while (cur != 1) {
            prev = cur;
            cur = next(cur);
            result.add((prev + cur) + result.get(result.size() - 1));
        }
        return result;
    }
    
    private int next(int n) {
        return n % 2 == 0 ? n / 2 : n * 3 + 1;
    }
}