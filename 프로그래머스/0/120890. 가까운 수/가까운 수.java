import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int diff = 101;
        int answer = 0;
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = Math.abs(array[i] - n);
            if (diff < temp) break;
            diff = temp;
            answer = array[i];
        }
        return answer;
    }
}