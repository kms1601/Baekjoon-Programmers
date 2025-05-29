import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        boolean[] swit = new boolean[N + 1];
        st = new StringTokenizer(BR.readLine());
        for (int n = 1; n <= N; n++) {
            if (st.nextToken().equals("1")) {
                swit[n] = true;
            }
        }
        int S = Integer.parseInt(BR.readLine());
        for (int s = 0; s < S; s++) {
            st = new StringTokenizer(BR.readLine());
            if (st.nextToken().equals("1")) {
                setSwitchMan(swit, Integer.parseInt(st.nextToken()));
            } else {
                setSwitchWoman(swit, Integer.parseInt(st.nextToken()));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (swit[i]) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            if (i % 20 == 0) {
                sb.append('\n');
            } else {
                sb.append(' ');
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static void setSwitchMan(boolean[] swit, int n) {
        for (int i = 0; i < swit.length; i += n) {
            swit[i] = !swit[i];
        }
    }

    private static void setSwitchWoman(boolean[] swit, int n) {
        swit[n] = !swit[n];
        int len = 1;
        for (; 0 < n - len && n + len < swit.length; len++) {
            if (swit[n - len] ^ swit[n + len]) break;
            swit[n - len] = !swit[n - len];
            swit[n + len] = !swit[n + len];
        }
    }
}
