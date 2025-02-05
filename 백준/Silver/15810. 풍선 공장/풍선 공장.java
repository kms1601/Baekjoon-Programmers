import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static int[] staffs;
    private static int M;

    public static void main(String[] args) throws IOException {
        String[] input = BR.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = BR.readLine().split(" ");
        staffs = new int[N];
        for (int i = 0; i < N; i++) {
            staffs[i] = Integer.parseInt(input[i]);
        }

        long left = 0, right = 1_000_000_000_000L;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (canMake(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(right);
    }

    private static boolean canMake(long time) {
        long result = 0;
        for (int staff : staffs) {
            result += time / staff;
        }
        return result >= M;
    }
}
