import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(BR.readLine());
            int s0 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int r0 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            if (s0 == 0) break;

            int score1;
            int score2;
            if (s0 < s1) {
                score1 = s1 * 10 + s0;
            } else {
                score1 = s0 * 10 + s1;
            }

            if (r0 < r1) {
                score2 = r1 * 10 + r0;
            } else {
                score2 = r0 * 10 + r1;
            }

            if (score1 == score2) {
                System.out.println("Tie.");
                continue;
            }

            if (score1 == 21) {
                System.out.println("Player 1 wins.");
                continue;
            }
            if (score2 == 21) {
                System.out.println("Player 2 wins.");
                continue;
            }

            if (s0 == s1 && r0 != r1) {
                System.out.println("Player 1 wins.");
                continue;
            }
            if (s0 != s1 && r0 == r1) {
                System.out.println("Player 2 wins.");
                continue;
            }

            if (score1 > score2) {
                System.out.println("Player 1 wins.");
                continue;
            }
            System.out.println("Player 2 wins.");
        }
    }
}
