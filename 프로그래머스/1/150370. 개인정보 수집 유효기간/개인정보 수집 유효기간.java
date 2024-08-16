import java.util.*;

class Solution {
    class Date implements Comparable<Date> {
        int year;
        int month;
        int day;
        
        Date(String date) {
            String[] split = date.split("\\.");
            year = Integer.parseInt(split[0]);
            month = Integer.parseInt(split[1]);
            day = Integer.parseInt(split[2]);
        }
        
        public void addMonth(int month) {
            this.month += month;
            
            if (this.month > 12) {
                if (this.month % 12 == 0) {
                    year += this.month / 12 - 1;
                    this.month = 12;
                } else {
                    year += this.month / 12;
                    this.month %= 12;
                }
            }
        }
        
        @Override
        public int compareTo(Date d) {
            int dy = this.year - d.year;
            int dm = this.month - d.month;
            int dd = this.day - d.day;
            
            if (dy != 0) return dy;
            if (dm != 0) return dm;
            return dd;
        }
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        Map<Character, Integer> termsList = new HashMap<>();
        StringTokenizer st;
        for (String term : terms) {
            st = new StringTokenizer(term);
            termsList.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }
        
        Date t = new Date(today);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            Date date = new Date(st.nextToken());
            char term = st.nextToken().charAt(0);
            
            date.addMonth(termsList.get(term));
            if (date.compareTo(t) <= 0) answer.add(i + 1);
        }
        return answer;
    }
}