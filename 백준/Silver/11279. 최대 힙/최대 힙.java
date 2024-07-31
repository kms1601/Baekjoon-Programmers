import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(100000, Collections.reverseOrder());

        for (int n = 0; n < N; n++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    bw.write("0");
                } else {
                    bw.write(String.valueOf(pq.poll()));
                }
                bw.write("\n");
            } else {
                pq.offer(x);
            }
        }
        bw.flush();
    }
}
