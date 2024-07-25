import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] children = new int[N];
        for (int n = 0; n < N; n++)
            children[n] = Integer.parseInt(br.readLine());

        System.out.println(N - ltsLength(children));
    }

    private static int ltsLength(int[] arr) {
        int l = arr.length;
        int[] max = new int[l];
        int answer = 0;
        for (int i = 0; i < l; i++) {
            max[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] <= arr[j]) continue;
                max[i] = Math.max(max[i], max[j] + 1);
            }
            answer = Math.max(answer, max[i]);
        }
        return answer;
    }
}
