import java.util.*;

class Solution {
    class Data {
        String str;
        int count;
        
        Data(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int len = begin.length();
        Deque<Data> queue = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();
        queue.add(new Data(begin, 0));
        visit.add(begin);
        
        while (!queue.isEmpty()) {
            Data cur = queue.poll();
            
            for (String word : words) {
                if (visit.contains(word)) continue;
                int count = 0;
                for (int i = 0; i < len; i++) {
                    if (cur.str.charAt(i) != word.charAt(i)) count++;
                }
                
                if (count != 1) continue;
                if (word.equals(target)) return cur.count + 1;
                queue.add(new Data(word, cur.count + 1));
                visit.add(word);
            }
        }
        
        return 0;
    }
}