import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int print = -2;

            switch (cmd) {
                case 1:
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        print = stack.pop();
                    } else {
                        print = -1;
                    }
                    break;
                case 3:
                    print = stack.size();
                    break;
                case 4:
                    if (!stack.isEmpty()) {
                        print = 0;
                    } else {
                        print = 1;
                    }
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        print = stack.peek();
                    } else {
                        print = -1;
                    }
            }
            if (print >= -1) {
                sb.append(print);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
