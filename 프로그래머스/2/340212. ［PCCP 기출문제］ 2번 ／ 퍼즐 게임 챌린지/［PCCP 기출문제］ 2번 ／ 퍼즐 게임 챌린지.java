class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 0, right = 100_000;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            long solvingTime = getSolvingTime(mid, diffs, times);
            if (solvingTime > limit) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
    
    private long getSolvingTime(int level, int[] diffs, int[] times) {
        long time = 0;
        for (int cur = 0; cur < diffs.length; cur++) {
            int diff = diffs[cur];
            if (diff <= level) {
                time += times[cur];
            } else {
                int wrong = diff - level;
                time += times[cur] * (wrong + 1) + (wrong) * times[cur - 1];
            }
        }
        return time;
    }
}