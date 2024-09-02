import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int[] count = new int[26];
        input.chars().forEach((c) -> count[c - 'a']++);

        int even = 0;
        int odd = 0;
        for (int c : count) {
            if (c == 0) continue;

            if (c % 2 == 0) even++;
            else odd++;
        }

        if (even > 0) {
            if (odd > 0) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(1);
        }
    }
}
