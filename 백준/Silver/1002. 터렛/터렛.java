import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long r1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            long r2 = Long.parseLong(st.nextToken());

            long distance = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

            if (distance == 0) {
                if (r1 == r2) System.out.println(-1);
                else System.out.println(0);
                continue;
            }

            long total = (r1 + r2) * (r1 + r2);
            long diff = (r1 - r2) * (r1 - r2);

            if (distance == total || distance == diff) {
                System.out.println(1);
            } else if (diff < distance && distance < total) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }
    }
}