class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1, right = Long.MAX_VALUE / 100;
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (getMax(times, mid) >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            } 
        }
        return answer;
    }
    
    private long getMax(int[] times, long time) {
        long result = 0;
        for (int t : times)
            result += (time / t);
        return result;
    }
}