import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        String[] picture = new String[N];

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                sb.append(BR.readLine());
            }
            picture[i] = sb.toString();
        }

        int a = 0, b = 0, min = 36;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int diffCount = getDiffCount(picture[i], picture[j]);
                if (diffCount < min) {
                    a = i + 1;
                    b = j + 1;
                    min = diffCount;
                }
            }
        }
        System.out.println(a + " " + b);
    }

    private static int getDiffCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < 35; i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}
