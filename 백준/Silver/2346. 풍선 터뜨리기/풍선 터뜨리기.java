import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> balloons = new LinkedList<>();
        for (int n = 0; n < N; n++)
            balloons.addLast(new int[]{Integer.parseInt(st.nextToken()), n + 1});

        int[] answer = new int[N];
        for (int n = 0; n < N - 1; n++) {
            int[] cur = balloons.pollFirst();
            answer[n] = cur[1];

            if (cur[0] > 0) {
                int move = (cur[0] - 1) % balloons.size();
                for (int i = 0; i < move; i++)
                    balloons.addLast(balloons.pollFirst());
            } else {
                int move = -cur[0] % balloons.size();
                for (int i = 0; i < move; i++)
                    balloons.addFirst(balloons.pollLast());
            }
        }
        answer[N - 1] = balloons.peekFirst()[1];
        Arrays.stream(answer).forEach(i -> System.out.print(i + " "));
    }
}
