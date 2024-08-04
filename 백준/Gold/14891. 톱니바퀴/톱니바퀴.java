import java.io.*;
import java.util.*;

public class Main {
    static class Gear {
        boolean[] teeth = new boolean[8];

        Gear(String teeth) {
            for (int i = 0; i < 8; i++)
                this.teeth[i] = teeth.charAt(i) == '1';
        }

        void rotateLeft() {
            boolean temp = teeth[0];
            for (int i = 1; i < 8; i++) teeth[i - 1] = teeth[i];
            teeth[7] = temp;
        }

        void rotateRight() {
            boolean temp = teeth[7];
            for (int i = 7; i >= 1; i--) teeth[i] = teeth[i - 1];
            teeth[0] = temp;
        }

        @Override
        public String toString() {
            return Arrays.toString(teeth);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gear[] gearSet = new Gear[5];
        for (int i = 1; i <= 4; i++) gearSet[i] = new Gear(br.readLine());
        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gear = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int[] rotate = new int[5];
            rotate[gear] = direction;

            for (int i = gear + 1; i <= 4; i++)
                if (gearSet[i - 1].teeth[2] != gearSet[i].teeth[6])
                    rotate[i] = -rotate[i - 1];

            for (int i = gear - 1; i >= 1; i--)
                if (gearSet[i + 1].teeth[6] != gearSet[i].teeth[2])
                    rotate[i] = -rotate[i + 1];

            for (int i = 1; i <= 4; i++) {
                if (rotate[i] == 1) gearSet[i].rotateRight();
                else if (rotate[i] == -1) gearSet[i].rotateLeft();
            }
        }

        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            int score = 1;
            answer += gearSet[i].teeth[0] ? (int) Math.pow(2, i - 1) : 0;
        }
        System.out.println(answer);
    }
}
