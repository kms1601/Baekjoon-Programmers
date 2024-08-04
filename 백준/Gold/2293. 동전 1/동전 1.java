import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Integer> coin = new ArrayList<>();
        int[] count = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            if (c <= k) {
                coin.add(c);
            }
        }

        if (coin.isEmpty()) {
            System.out.println(1);
        } else {
            for (int c : coin) {
                count[c]++;
                for (int i = c; i <= k; i++) {
                    count[i] += count[i - c];
                }
            }
            System.out.println(count[k]);
        }
    }
}
