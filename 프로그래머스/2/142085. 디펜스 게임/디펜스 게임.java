import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : enemy) {
            n -= e;
            pq.offer(e);
            if (n < 0) {
                if (k > 0) {
                    k--;
                    n += pq.poll();
                } else {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}