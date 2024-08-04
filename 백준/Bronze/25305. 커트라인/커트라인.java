import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringTokenizer st;
        st = new StringTokenizer(s.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] scores = new Integer[N];
        st = new StringTokenizer(s.nextLine());

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Comparator<Integer> reverseComparator = Comparator.reverseOrder();
        Arrays.sort(scores, reverseComparator);
        System.out.println(scores[k - 1]);
        s.close();
    }
}