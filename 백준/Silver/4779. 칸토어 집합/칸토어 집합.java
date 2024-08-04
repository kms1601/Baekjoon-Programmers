import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            sb.delete(0, sb.length());
            cantor(N, true);
            System.out.println(sb);
        }
    }

    private static void cantor(int N, boolean set) {
        if (N == 0) {
            sb.append(set ? "-" : " ");
            return;
        }

        cantor(N - 1, set);
        cantor(N - 1, false);
        cantor(N - 1, set);
    }
}
