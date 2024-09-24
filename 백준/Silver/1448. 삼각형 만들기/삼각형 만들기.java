import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        int[] len = new int[N];
        for (int i = 0; i < N; i++) {
            len[i] = Integer.parseInt(BR.readLine());
        }
        Arrays.sort(len);
        for (int i = N - 1; i >= 2; i--) {
            if (len[i] < len[i - 1] + len[i - 2]) {
                System.out.println(len[i] + len[i - 1] + len[i - 2]);
                return;
            }
        }
        System.out.println(-1);
    }
}
