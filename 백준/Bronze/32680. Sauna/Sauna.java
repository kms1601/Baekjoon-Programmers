import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        int min = 0;
        int max = 200000;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(BR.readLine());
            min = Math.max(min, Integer.parseInt(st.nextToken()));
            max = Math.min(max, Integer.parseInt(st.nextToken()));
        }

        int count = max - min + 1;
        if (count > 0) {
            System.out.printf("%d %d", count, min);
        } else {
            System.out.println("bad news");
        }
    }
}
