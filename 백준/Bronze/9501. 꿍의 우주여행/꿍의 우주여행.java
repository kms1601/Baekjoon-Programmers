import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int vi = Integer.parseInt(st.nextToken());
                int fi = Integer.parseInt(st.nextToken());
                int ci = Integer.parseInt(st.nextToken());
                if (vi * fi / ci >= D) count++;
            }
            System.out.println(count);
        }
    }
}
