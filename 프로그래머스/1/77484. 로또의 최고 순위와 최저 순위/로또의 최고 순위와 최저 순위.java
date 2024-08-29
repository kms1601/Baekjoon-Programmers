class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] lb = new boolean[46];
        for (int lotto : win_nums) {
            lb[lotto] = true;
        }
        
        int min = 0;
        int max = 0;
        for (int lotto : lottos) {
            if (lb[lotto]) {
                min++;
                max++;
            }
            else if (lotto == 0) max++;
        }
        
        int[] answer = new int[2];
        answer[0] = max <= 1 ? 6 : 7 - max;
        answer[1] =  min <= 1 ? 6 : 7 - min;
        return answer;
    }
}