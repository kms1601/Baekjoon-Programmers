import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static class Answer {
        String number;
        int strike;
        int ball;

        public Answer(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }

        public boolean test(String number) {
            int strike = 0;
            int ball = 0;
            boolean[] used = new boolean[3];

            strike += match(number, 0, used);
            ball += match(number, 1, used) + match(number, 2, used);
            return this.strike == strike && this.ball == ball;
        }

        private int match(String number, int offset, boolean[] used) {
            int result = 0;
            for (int i = 0; i < 3; i++) {
                if (!used[i] && number.charAt((i + offset) % 3) == this.number.charAt(i)) {
                    result++;
                    used[i] = true;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Answer[] answers = new Answer[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            answers[i] = new Answer(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int i = 111; i <= 999; i++) {
            String number = String.valueOf(i);
            if (number.contains("0")) continue;
            if (number.charAt(0) == number.charAt(1) || number.charAt(0) == number.charAt(2) || number.charAt(1) == number.charAt(2)) continue;
            
            if (Arrays.stream(answers).filter((a) -> a.test(number)).count() == N) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
