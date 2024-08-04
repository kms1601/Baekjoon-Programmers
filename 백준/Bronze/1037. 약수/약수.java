import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] divisor = new int[N];
        for (int n = 0; n < N; n++)
            divisor[n] = Integer.parseInt(st.nextToken());

        Arrays.sort(divisor);
        System.out.println(divisor[0] * divisor[N - 1]);
    }
}
