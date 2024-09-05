import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(count);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(-1);
        list2.add(-1);

        for (int i : count) {
            if (list1.get(list1.size() - 1) + 1 == i) {
                list1.add(i);
            } else if (list2.get(list2.size() - 1) + 1 == i) {
                list2.add(i);
            } else {
                System.out.println(0);
                return;
            }
        }

        if (list1.size() == list2.size()) {
            System.out.println((int) Math.pow(2, list2.size() - 1));
        } else {
            System.out.println((int) Math.pow(2, list2.size()));
        }
    }
}
