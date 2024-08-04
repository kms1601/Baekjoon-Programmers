import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++)
            System.out.println(solve());
    }

    public static int solve() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] tree = new int[N + 1];
        StringTokenizer st;
        for (int n = 0; n < N - 1; n++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[c] = p;
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        while (a != 0) {
            set.add(a);
            a = tree[a];
        }

        while (true) {
            if (set.contains(b)) return b;
            b = tree[b];
        }
    }
}
