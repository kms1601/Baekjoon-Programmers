import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(BR.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(BR.readLine());
            String S = BR.readLine();
            int[] distance = new int[N];
            Arrays.fill(distance, N - 1);
            for (int i = 0; i < N;) {
                if (S.charAt(i) == '1') {
                    distance[i] = 0;
                    int temp = i - 1;
                    while (temp >= 0 && distance[temp] > i - temp) {
                        distance[temp] = i - temp--;
                    }
                    temp = i + 1;
                    while (temp < N && S.charAt(temp) == '0') {
                        distance[temp] = temp++ - i;
                    }
                    i = temp;
                } else {
                    i++;
                }
            }
            sb.append(String.format("Case #%d: %d\n", t + 1, Arrays.stream(distance).sum()));
        }
        System.out.println(sb);
    }
}
