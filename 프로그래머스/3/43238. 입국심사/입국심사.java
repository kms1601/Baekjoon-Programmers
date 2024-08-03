import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1, right = Long.MAX_VALUE / 100;
        while (left <= right) {
            long mid = (left + right) / 2;
            long max = 0;
            
            for (int time : times)
                max += (mid / time);
            
            if (max >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            } 
        }
        return answer;
    }
}