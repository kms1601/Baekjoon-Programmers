import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long sum = sum1 + sum2;
        
        if (sum % 2 == 1) return -1;
        
        int answer = 0;
        for (int i = 0; i < queue1.length * 2 + 3; i++) {
            if (sum1 > sum / 2) {
                int poll = q1.poll();
                q2.offer(poll);
                sum1 -= poll;
                sum2 += poll;
            } else if (sum1 < sum / 2) {
                int poll = q2.poll();
                q1.offer(poll);
                sum1 += poll;
                sum2 -= poll;
            } else {
                return answer;
            }
            answer++;
        }
        return -1;
    }
}