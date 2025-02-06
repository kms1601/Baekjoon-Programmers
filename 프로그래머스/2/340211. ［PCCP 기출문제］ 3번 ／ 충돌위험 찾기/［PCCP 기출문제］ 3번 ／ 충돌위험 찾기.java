import java.util.*;

class Solution {
    private int[][] points;
    
    class Robot {
        int r, c;
        int cur;
        int[] route;
        
        public Robot(int[] route) {
            this.r = points[route[0] - 1][0];
            this.c = points[route[0] - 1][1];
            this.route = route;
            this.cur = 0;
        }
        
        public boolean move() {
            if (cur == route.length - 1) return false;
            int nr = points[route[cur + 1]  - 1][0], nc = points[route[cur + 1] - 1][1];
            if (r != nr) {
                int diff = nr - r;
                r += diff / Math.abs(diff);
            } else if (c != nc) {
                int diff = nc - c;
                c += diff / Math.abs(diff);
            }
            
            if (r == nr && c == nc) cur++;
            
            return true;
        }
        
        @Override
        public String toString() {
            return String.format("%d %d", r, c);
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        List<Robot> robots = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int[] route : routes) {
            Robot robot = new Robot(route);
            robots.add(robot);
            String str = robot.toString();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
    
        int collision = 0;
        for (String str : map.keySet()) {
                if (map.get(str) >= 2) collision++;
            }
        
        boolean flag = true;
        while (flag) {
            map.clear();
            flag = false;
            for (Robot robot : robots) {
                 if (!robot.move()) continue;
                String result = robot.toString();
                flag = true;
                map.put(result, map.getOrDefault(result, 0) + 1);
            }
            
            for (String str : map.keySet()) {
                if (map.get(str) >= 2) collision++;
            }
        }
        return collision;
    }
}