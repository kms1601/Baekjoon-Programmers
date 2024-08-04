import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String formula = br.readLine();
        Map<Character, Integer> table = new HashMap<>();
        for (int n = 0; n < N; n++)
            table.put((char) (n + 'A'), Integer.parseInt(br.readLine()));

        Deque<Double> stack = new LinkedList<>();
        for (char c : formula.toCharArray()) {
            switch (c) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-':
                    stack.push(- stack.pop() + stack.pop());
                    break;
                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/':
                    stack.push(1 / stack.pop() * stack.pop());
                    break;
                default:
                    stack.push((double) table.get(c));
            }
        }
        System.out.printf("%.2f", stack.peek());
    }
}
