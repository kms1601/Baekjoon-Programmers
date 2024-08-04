import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(int l, int r) {
        if (r >= 4) return r;
        
        int num = 0;
        for (int i = r; i >= l; i--)
            num += (int) (Math.pow(2, i) * Math.pow(10, r - i));
        
        int result = 0;
        while (num % 2 == 0) {
            num /= 2;
            result++;
        }
        return result;
    }
}
