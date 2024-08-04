import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void mark(StringBuilder problem) {
        boolean[] eval = eval(problem);

        if (eval[0]) {
            problem.setCharAt(8, '*');
            if (eval[1]) {
                for (int i = 1; i < 6; i++) {
                    problem.setCharAt(i, '*');
                    problem.setCharAt(i + 16, '*');
                    problem.setCharAt(14, '*');
                }
            } else {
                for (int i = 1; i < 7; i++) {
                    problem.setCharAt(i, '*');
                    problem.setCharAt(i + 16, '*');
                    problem.setCharAt(15, '*');
                }
            }
            return;
        }
        problem.setCharAt(3, '/');
        problem.setCharAt(10, '/');
        problem.setCharAt(17, '/');
    }


    static boolean[] eval(StringBuilder problem) {
        boolean[] result = new boolean[2];
        int left = problem.charAt(9) - '0';
        int right = problem.charAt(11) - '0';
        int answer;

        if (problem.charAt(14) == '.') {
            answer = problem.charAt(13) - '0';
            result[1] = true;
        } else {
            answer = Integer.parseInt(problem.substring(13, 15));
        }

        if (left + right == answer) {
            result[0] = true;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder[] result = new StringBuilder[N * 3];

        for (int i = 0; i < N * 3; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            String line2 = br.readLine();
            String line3 = br.readLine();

            for (int j = 0; j < M; j++) {
                StringBuilder problem = new StringBuilder();
                problem.append(line1, j * 8, (j + 1) * 8);
                problem.append(line2, j * 8, (j + 1) * 8);
                problem.append(line3, j * 8, (j + 1) * 8);

                mark(problem);
                result[i * 3].append(problem.substring(0, 8));
                result[i * 3 + 1].append(problem.substring(8, 16));
                result[i * 3 + 2].append(problem.substring(16, 24));
            }
        }

        for (StringBuilder sb : result) {
            System.out.println(sb);
        }
    }
}
