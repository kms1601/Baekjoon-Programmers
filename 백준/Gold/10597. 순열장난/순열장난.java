import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static String seq;
    private static int N;
    private static List<Integer> result = new ArrayList<>();
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        seq = BR.readLine();
        if (seq.length() <= 9) {
            for (char c : seq.toCharArray()) {
                System.out.printf("%c ", c);
            }
        } else {
            N = (seq.length() - 9) / 2 + 9;
            used = new boolean[N + 1];
            getSeq(0);
        }
    }

    private static void getSeq(int cur) {
        if (cur == seq.length()) {
            result.forEach((e) -> System.out.printf("%d ", e));
            System.exit(0);
        }

        int a = Integer.parseInt(seq.substring(cur, cur + 1));

        if (a == 0) return;
        if (!used[a]) {
            used[a] = true;
            result.add(a);
            getSeq(cur + 1);
            result.remove(result.size() - 1);
            used[a] = false;
        }

        if (cur == seq.length() - 1) return;
        a = Integer.parseInt(seq.substring(cur, cur + 2));
        if (a <= N && !used[a]) {
            used[a] = true;
            result.add(a);
            getSeq(cur + 2);
            result.remove(result.size() - 1);
            used[a] = false;
        }
    }
}
