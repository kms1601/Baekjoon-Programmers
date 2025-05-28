import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int comp = Integer.compare(Math.abs(a), Math.abs(b));
            return comp == 0 ? Integer.compare(a, b) : comp;
        });
        for (int n = 0; n < N; n++) {
            int cmd = Integer.parseInt(BR.readLine());
            if (cmd == 0) {
                if (pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll());
                sb.append('\n');
                continue;
            }
            pq.add(cmd);
        }
        System.out.println(sb);
    }
}
