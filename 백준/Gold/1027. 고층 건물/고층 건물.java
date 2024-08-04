import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        building = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, getMax(i));
        System.out.println(max);
    }

    private static int getMax(int start) {
        double[] slopes = new double[N];
        for (int i = 0; i < N; i++)
            slopes[i] = (double) (building[i] - building[start]) / (i - start);

        int result = 0;
        loop:
        for (int i = start + 1; i < N; i++) {
            for (int j = start + 1; j < i; j++) {
                if (slopes[i] <= slopes[j]) continue loop;
            }
            result++;
        }

        loop:
        for (int i = start - 1; i >= 0; i--) {
            for (int j = start - 1; j > i; j--) {
                if (slopes[i] >= slopes[j]) continue loop;
            }
            result++;
        }

        return result;
    }
}
