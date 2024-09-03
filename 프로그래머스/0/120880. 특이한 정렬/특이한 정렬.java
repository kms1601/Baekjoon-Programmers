import java.util.*;

class Solution {
    public List<Integer> solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(numlist).forEach((e) -> list.add(e));
        
        list.sort((a, b) -> {
            int c = Integer.compare(Math.abs(a - n), Math.abs(b - n));
            if (c != 0) return c;
            return Integer.compare(b, a);
        });
        return list;
    }
}