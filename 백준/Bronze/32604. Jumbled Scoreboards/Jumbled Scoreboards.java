import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        int a = 0, b = 0;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(BR.readLine());
            int na = Integer.parseInt(st.nextToken());
            int nb = Integer.parseInt(st.nextToken());
            if (a > na || b > nb) {
                System.out.println("no");
                System.exit(0);
            }
            a = na;
            b = nb;
        }
        System.out.println("yes");
    }
}
