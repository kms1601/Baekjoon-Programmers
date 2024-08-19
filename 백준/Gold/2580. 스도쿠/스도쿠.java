import java.io.*;
import java.util.*;

public class Main {
    private static int[][] sudoku = new int[9][9];
    private static NumberSet[][] cell = new NumberSet[3][3];
    private static NumberSet[] row = new NumberSet[9];
    private static NumberSet[] col = new NumberSet[9];

    static class NumberSet {
        private boolean[] set = new boolean[9];

        public boolean add(int num) {
            if (contains(num)) return false;
            set[num - 1] = true;
            return true;
        }

        public void remove(int num) {
            set[num - 1] = false;
        }

        private boolean contains(int num) {
            return set[num - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new NumberSet();
                row[i * 3 + j] = new NumberSet();
                col[i * 3 + j] = new NumberSet();
            }
        }

        for (int r = 0; r < 9; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 9; c++) {
                int ch = Integer.parseInt(st.nextToken());
                if (ch == 0) continue;
                cell[r / 3][c / 3].add(ch);
                row[r].add(ch);
                col[c].add(ch);
                sudoku[r][c] = ch;
            }
        }

        fill(0, 0);
    }

    private static void fill(int r, int c) {
        if (r == 9) print();
        if (c == 9) {
            fill(r + 1, 0);
            return;
        }
        if (sudoku[r][c] > 0) {
            fill(r, c + 1);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!cell[r / 3][c / 3].add(i)) continue;
            if (!row[r].add(i)) {
                cell[r / 3][c / 3].remove(i);
                continue;
            }
            if (!col[c].add(i)) {
                cell[r / 3][c / 3].remove(i);
                row[r].remove(i);
                continue;
            }

            sudoku[r][c] = i;
            fill(r, c + 1);

            cell[r / 3][c / 3].remove(i);
            row[r].remove(i);
            col[c].remove(i);
            sudoku[r][c] = 0;
        }
    }

    static void print() {
        for (int[] r : sudoku) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.exit(0);
    }
}
