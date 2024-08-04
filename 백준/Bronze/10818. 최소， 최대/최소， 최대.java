import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = -1000000;
        int min = 1000000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (min > num) {
                min = num;
            }

            if (max < num) {
                max = num;
            }
        }
        System.out.println("" + min + " " + max);
        br.close();
    }
}
