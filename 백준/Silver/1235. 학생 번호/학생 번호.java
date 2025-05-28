import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        String[] students = new String[N];
        for (int n = 0; n < N; n++) {
            students[n] = BR.readLine();
        }

        int len = students[0].length();
        loop:
        for (int i = 1; i <= len; i++) {
            Set<String> set = new HashSet<>();
            for (String student : students) {
                String cut = student.substring(len - i, len);
                if (set.contains(cut)) {
                    continue loop;
                }
                set.add(cut);
            }
            System.out.println(i);
            break;
        }
    }
}
