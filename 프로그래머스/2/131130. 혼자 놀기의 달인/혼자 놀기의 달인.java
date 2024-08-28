import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] open = new boolean[n];
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (open[i]) continue;
            int j = i;
            int score = 0;
            while (!open[j]) {
                score++;
                open[j] = true;
                j = cards[j] - 1;
            }
            group.add(score);
        }
        
        if (group.size() <= 1) return 0;
        group.sort(Collections.reverseOrder());
        return group.get(0) * group.get(1);
    }
}