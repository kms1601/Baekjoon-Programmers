import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;
    private static int N;
    private static int S;
    private static int[] arr;
    private static int result = 0;
    private static int count;
    private static List<Integer> combination = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(BR.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(BR.readLine());
        arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            count = i;
            combination(0, 0);
        }

        System.out.println(result);
    }

    private static void combination(int depth, int offset) {
        if (depth == count) {
            int sum = 0;
            for (int i : combination) {
                sum += i;
            }

            if (sum == S) result++;
            return;
        }

        for (int n = offset; n < N; n++) {
            combination.add(arr[n]);
            combination(depth + 1, n + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
