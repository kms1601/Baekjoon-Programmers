import java.io.*;

public class Main {
    private static boolean[][] image;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int k = (int) (Math.log(N / 3) / Math.log(2));
        int M = (int) (Math.pow(2, k)) * 5 + (int) (Math.pow(2, k)) - 1;
        image = new boolean[N][M];
        draw(0, M / 2, k);

        for (boolean[] r : image) {
            for (boolean c : r) {
                if (c) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void draw(int r, int c, int k) {
        if (k == 0) {
            image[r][c] = true;
            image[r + 1][c - 1] = true;
            image[r + 1][c + 1] = true;
            image[r + 2][c - 2] = true;
            image[r + 2][c - 1] = true;
            image[r + 2][c] = true;
            image[r + 2][c + 1] = true;
            image[r + 2][c + 2] = true;
            return;
        }

        int next = (int) (3 * Math.pow(2, k - 1));
        draw(r, c, k - 1);
        draw(r + next, c - next, k - 1);
        draw(r + next, c + next, k - 1);
    }
}
