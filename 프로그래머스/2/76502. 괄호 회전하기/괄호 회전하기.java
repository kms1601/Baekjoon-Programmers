import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s.substring(i, s.length()) + s.substring(0, i))) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (test(stack, '(')) return false;
                    break;
                case ']':
                    if (test(stack, '[')) return false;
                    break;
                case '}':
                    if (test(stack, '{')) return false;
                    break;
                default:
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    
    private boolean test(Deque<Character> stack, char c) {
        return stack.isEmpty() || stack.pop() != c;
    }
}