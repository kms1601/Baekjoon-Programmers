import java.io.*;
import java.util.*;

public class Main {
    static int[][] function;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        function = new int[20][m + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++)
            function[0][i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j <= m; j++) {
                function[i][j] = function[i - 1][function[i - 1][j]];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            bw.write(solve(n, x) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int solve(int n, int x) {
        String bin = Integer.toBinaryString(n);
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(bin.length() - 1 - i) == '0') continue;
            int[] func = function[i];
            x = func[x];
        }
        return x;
    }
}
