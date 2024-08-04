import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[] score = new int[n];
        double sum = 0.0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            score[i] = num;
            if (max < num) {
                max = num;
            }
        }
        for (int s : score) {
            sum += (s / (double) max) * 100;
        }
        System.out.printf("%.2f", sum / n);
        br.close();
    }
}
