import java.util.*;

class Solution {
    Map<String, Set<Ticket>> map = new HashMap<>();
    List<String> answer = new ArrayList<>();
    int count = 0;
    boolean flag = false;
    
    class Ticket implements Comparable<Ticket> {
        String to;
        boolean used = false;
        
        Ticket(String to) {
            this.to = to;
        }
        
        @Override
        public int compareTo(Ticket t) {
            int result = this.to.compareTo(t.to);
            if (result == 0) return 1;
            return result;
        }
    }
    
    public List<String> solution(String[][] tickets) {
        count = tickets.length;
        
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) map.put(ticket[0], new TreeSet<>());
            map.get(ticket[0]).add(new Ticket(ticket[1]));
        }
        
        answer.add("ICN");
        dfs("ICN", 1);
        
        return answer;
    }
    
    private void dfs(String cur, int count) {
        if (!map.containsKey(cur)) return;
        
        for (Ticket next : map.get(cur)) {
            if (next.used) continue;
            
            if (!flag) answer.add(next.to);
            next.used = true;
            if (count == this.count) {
                flag = true;
            }
            
            dfs(next.to, count + 1);
            
            if (!flag) answer.remove(answer.size() - 1);
            next.used = false;
        }
    }
}