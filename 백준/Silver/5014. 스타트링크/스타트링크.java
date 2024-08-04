import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int F = Integer.parseInt(s[0]), S = Integer.parseInt(s[1]), G = Integer.parseInt(s[2]), U = Integer.parseInt(s[3]), D = Integer.parseInt(s[4]);

        Queue<Integer> queue = new LinkedList<>();
        Integer[] move = new Integer[F + 1];
        queue.add(S);
        move[S] = 0;
        String answer = "use the stairs";
        while (!queue.isEmpty()) {
            int floor = queue.remove();

            if (floor == G) {
                answer = String.valueOf(move[floor]);
            }

            if (floor - D > 0 && move[floor - D] == null) {
                queue.add(floor - D);
                move[floor - D] = move[floor] + 1;
            }

            if (floor + U <= F && move[floor + U] == null) {
                queue.add(floor + U);
                move[floor + U] = move[floor] + 1;
            }
        }
        System.out.println(answer);
    }
}
