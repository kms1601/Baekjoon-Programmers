import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] bucket = new int[n];
        for (int i = 0; i < n; i++) {
            bucket[i] = i + 1;
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = bucket[a - 1];
            bucket[a - 1] = bucket[b - 1];
            bucket[b - 1] = tmp;
        }
        for (int num : bucket) {
            System.out.print(num + " ");
        }
        br.close();
    }
}