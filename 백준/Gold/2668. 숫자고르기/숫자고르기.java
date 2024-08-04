import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            if (isCycle(i, i, new boolean[N + 1])) answer.add(i);

        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    private static boolean isCycle(int i, int s, boolean[] visit) {
        visit[i] = true;
        int temp = arr[i];
        if (visit[temp] && temp == s) return true;
        else if (visit[temp]) return false;
        return isCycle(temp, s, visit);
    }
}
