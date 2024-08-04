import java.io.*;
import java.util.*;

public class Main {
    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    static class Cell {
        int type;
        int r, c;

        Cell(int type, int r, int c) {
            this.type = type;
            this.r = r;
            this.c = c;
        }

        List<Integer> getVision(int direction) {
            List<Integer> result = new ArrayList<>(4);

            switch (type) {
                case 1:
                    result.add(1);
                    break;
                case 2:
                    result.add(1);
                    result.add(3);
                    break;
                case 3:
                    result.add(0);
                    result.add(1);
                    break;
                case 4:
                    result.add(3);
                    result.add(0);
                    result.add(1);
                    break;
                case 5:
                    result.add(0);
                    result.add(1);
                    result.add(2);
                    result.add(3);
            }

            for (int i = 0; i < result.size(); i++)
                result.set(i, (result.get(i) + direction) % 4);

            return result;
        }

        @Override
        public String toString() {
            return String.valueOf(type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Cell[][] office = new Cell[N][M];
        List<Cell> cctvList = new ArrayList<>(8);
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int type = Integer.parseInt(st.nextToken());
                Cell cell = new Cell(type, r, c);
                if (1 <= type && type <= 5) cctvList.add(cell);
                office[r][c] = cell;
            }
        }

        int cctvCount = cctvList.size();
        int[] direction = new int[cctvCount];
        int min = 64;
        for (int i = 0; i < Math.pow(4, cctvCount); i++) {
            boolean[][] isInVision = new boolean[N][M];
            for (int j = 0; j < cctvCount; j++) {
                Cell cctv = cctvList.get(j);
                List<Integer> vision = cctv.getVision(direction[j]);

                int r = cctv.r;
                int c = cctv.c;
                for (int d : vision) {
                    int dr = r;
                    int dc = c;
                    while (true) {
                        dr += DR[d];
                        dc += DC[d];
                        if (dr < 0 || dr >= N || dc < 0 || dc >= M || office[dr][dc].type == 6)
                            break;
                        isInVision[dr][dc] = true;
                    }
                }
            }

            int blind = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!isInVision[j][k] && office[j][k].type == 0) blind++;
                }
            }
            min = Math.min(min, blind);

            for (int j = 0; j < cctvList.size(); j++) {
                direction[j]++;
                if (direction[j] != 4) break;
                direction[j] = 0;
            }
        }
        System.out.println(min);
    }
}
