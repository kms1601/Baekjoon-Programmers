import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        Map<Integer, Integer> stalagmites = new HashMap<>();
        Map<Integer, Integer> stalactites = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                stalagmites.put(height, stalagmites.getOrDefault(height, 0) + 1);
            } else {
                stalactites.put(height, stalactites.getOrDefault(height, 0) + 1);
            }
        }

        int min = N / 2;
        int count = 1;
        int cur = min;
        for (int h = 1; h < H; h++) {
            cur -= stalagmites.getOrDefault(h, 0);
            cur += stalactites.getOrDefault(H - h, 0);
            if (min > cur) {
                min = cur;
                count = 0;
            }

            if (min == cur) {
                count++;
            }
        }
        System.out.println(min + " " + count);
    }
}
