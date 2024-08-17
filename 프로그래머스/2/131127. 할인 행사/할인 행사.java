import java.util.*;

class Solution {
    private Map<String, Integer> count = new HashMap<>();
    private String[] want;
    private int[] number;
    
    public int solution(String[] want, int[] number, String[] discount) {
        this.want = want;
        this.number = number;
        
        for (int i = 0; i < 10; i++) {
            String item = discount[i];
            count.put(item, count.getOrDefault(item, 0) + 1);
        }
        
        int answer = 0;
        for (int i = 10; i < discount.length; i++) {
            if (check()) answer++;
            String remove = discount[i - 10];
            String add = discount[i];
            count.put(remove, count.get(remove) - 1);
            count.put(add, count.getOrDefault(add, 0) + 1);
        }
        
        if (check()) answer++;
        return answer;
    }
    
    private boolean check() {
        for (int i = 0; i < want.length; i++) {
            String item = want[i];
            if (!count.containsKey(item) || count.get(item) < number[i]) {
                return false;
            }
        }
        return true;
    }
}