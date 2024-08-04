import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] mini = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mini[i][0] = Integer.parseInt(st.nextToken());
            mini[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(mini, Comparator
                .<int[], Integer>comparing(arr -> arr[0], Comparator.reverseOrder())
                .thenComparing(arr -> arr[1]));
        System.out.println(mini[0][0] + " " + mini[0][1] + " " + mini[1][0] + " " + mini[1][1]);

        Arrays.sort(mini, Comparator
                .<int[], Integer>comparing(arr -> arr[1])
                .thenComparing(arr -> arr[0], Comparator.reverseOrder()));
        System.out.println(mini[0][0] + " " + mini[0][1] + " " + mini[1][0] + " " + mini[1][1]);
    }
}
