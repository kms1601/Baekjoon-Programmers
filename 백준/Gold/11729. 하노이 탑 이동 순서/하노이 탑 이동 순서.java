import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        bw.write(String.format("%d%n", (int) Math.pow(2, N) - 1));
        move(N, 1, 3, 2);
        bw.flush();
        bw.close();
    }

    private static void move(int h, int from, int to, int remain) throws IOException {
        if (h == 0) return;
        move(h - 1, from, remain, to);
        bw.write(String.format("%d %d%n", from, to));
        move(h - 1, remain, to, from);
    }
}
