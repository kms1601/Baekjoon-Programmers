import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int num = 1;
        int turn = 1;
        char last = words[0].charAt(0);
        Set<String> prev = new HashSet<>();
        for (String word : words) {
            if (last != word.charAt(0) || prev.contains(word)) {
                answer[0] = num;
                answer[1] = turn;
                break;
            }
            last = word.charAt(word.length() - 1);
            prev.add(word);
            num++;
            if (num > n) {
                num = 1;
                turn++;
            } 
        }
        return answer;
    }
}