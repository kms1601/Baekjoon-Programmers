import java.util.*;

class Solution {
    class Plan {
        String name;
        int start;
        int playtime;
        
        Plan(String[] plan) {
            this.name = plan[0];
            String[] split = plan[1].split(":");
            this.start = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            this.playtime = Integer.parseInt(plan[2]);
        }
    }
    
    public String[] solution(String[][] plans) {
        Plan[] ps = new Plan[plans.length];
        for (int i = 0; i < plans.length; i++)
            ps[i] = new Plan(plans[i]);
        Arrays.sort(ps, (a, b) -> Integer.compare(a.start, b.start));
        Stack<Plan> s = new Stack<>();
        String[] answer = new String[plans.length];
        int finished = 0;
        for (Plan p : ps) {
            if (s.isEmpty()) {
                s.push(p);
                continue;
            }
            
            while (!s.isEmpty()) {
                Plan cur = s.peek();
                if (cur.start + cur.playtime <= p.start) {
                    answer[finished++] = s.pop().name;
                    if (!s.isEmpty()) {
                        s.peek().start = cur.start + cur.playtime;
                    } else {
                        s.push(p);
                        break;
                    }
                } else {
                    cur.playtime -= (p.start - cur.start);
                    s.push(p);
                    break;
                }
            }
        }
        
        while (!s.isEmpty()) answer[finished++] = s.pop().name;
        return answer;
    }
}