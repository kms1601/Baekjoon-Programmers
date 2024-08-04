import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] bucket = new int[n];
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for (int j = start - 1; j < end; j++) {
                bucket[j] = num;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(bucket[i] + " ");
        }
        br.close();
    }
}