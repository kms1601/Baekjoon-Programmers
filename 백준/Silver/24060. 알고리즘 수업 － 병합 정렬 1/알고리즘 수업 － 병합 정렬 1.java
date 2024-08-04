import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) arr[n] = Integer.parseInt(st.nextToken());
        mergeSort(arr, 0, N - 1);
        System.out.println(answer);
    }

    private static void mergeSort(int[] arr, int p, int r) {
        if (p >= r) return;
        int mid = (p + r) / 2;
        mergeSort(arr, p, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, p, mid, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int i = p, j = q + 1, t = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = arr[j++];
        }

        while (i <= q) tmp[t++] = arr[i++];
        while (j <= r) tmp[t++] = arr[j++];

        i = p;
        t = 0;
        while (i <= r) {
            K--;
            arr[i++] = tmp[t++];
            if (K == 0) answer = tmp[t - 1];
        }
    }
}
