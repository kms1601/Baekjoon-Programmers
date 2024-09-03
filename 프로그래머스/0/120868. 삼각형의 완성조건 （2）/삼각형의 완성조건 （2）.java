import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        return 2 * sides[0] - 1;
    }
}