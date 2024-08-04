import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> line = new Stack<>();
        Stack<Integer> byway = new Stack<>();
        String[] sArr = br.readLine().split(" ");

        for (int i = N - 1; i >= 0; i--) {
            line.push(Integer.parseInt(sArr[i]));
        }

        int order = 1;
        while (!line.isEmpty()) {
            if (line.peek() == order) {
                line.pop();
                order++;
            } else {
                if (!byway.isEmpty() && byway.peek() == order) {
                    byway.pop();
                    order++;
                } else {
                    byway.push(line.pop());
                }
            }
        }

        while (!byway.isEmpty()) {
            if (byway.pop() != order) {
                System.out.println("Sad");
                return;
            }
            order++;
        }
        System.out.println("Nice");
    }
}
