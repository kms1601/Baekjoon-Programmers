import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            while (!stack.isEmpty() && stack.peek()[0] < number)
                answer[stack.pop()[1]] = number;
            stack.push(new int[]{number, i});
        }
        return answer;
    }
}