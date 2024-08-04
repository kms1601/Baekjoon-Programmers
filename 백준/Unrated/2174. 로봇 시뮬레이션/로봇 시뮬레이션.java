import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Robot[][] grid;
    static int A;
    static int B;

    static class Robot {
        int name;
        int x, y;
        int direction;
        int[] arr;

        public Robot(int name, int x, int y, char direction) {
            this.name = name;
            this.x = x;
            this.y = y;
            switch (direction) {
                case 'N':
                    this.direction = 0;
                    break;
                case 'E':
                    this.direction = 1;
                    break;
                case 'S':
                    this.direction = 2;
                    break;
                case 'W':
                    this.direction = 3;
            }

            setArr();
        }

        public void turnLeft(int count) {
            direction = direction - count % 4;
            direction = direction < 0 ? direction + 4 : direction;
            setArr();
        }

        public void turnRight(int count) {
            direction = (direction + count) % 4;
            setArr();
        }

        public void setArr() {
            switch (direction) {
                case 0:
                    this.arr = new int[]{0, 1};
                    break;
                case 1:
                    this.arr = new int[]{1, 0};
                    break;
                case 2:
                    this.arr = new int[]{0, -1};
                    break;
                case 3:
                    this.arr = new int[]{-1, 0};
                    break;
                default:
                    this.arr = new int[]{0, 0};
            };
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        grid = new Robot[B][A];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Robot[] robots = new Robot[N];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            robots[n] = new Robot(n + 1, x, y, st.nextToken().charAt(0));
            grid[B - y][x - 1] = robots[n];
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 'L':
                    robots[no - 1].turnLeft(count);
                    break;
                case 'R':
                    robots[no - 1].turnRight(count);
                    break;
                case 'F':
                    String result = move(robots[no - 1], count);
                    if (result != null) {
                        System.out.println(result);
                        return;
                    }
            }
        }
        System.out.println("OK");
    }

    private static String move(Robot robot, int count) {
        if (count == 0) return null;
        int[] dir = robot.arr;
        int nx = robot.x + dir[0], ny = robot.y + dir[1];
        if (1 > nx || nx > A || 1 > ny || ny > B)
            return String.format("Robot %d crashes into the wall", robot.name);

        if (grid[B - ny][nx - 1] != null)
            return String.format("Robot %d crashes into robot %d", robot.name, grid[B - ny][nx - 1].name);

        grid[B - robot.y][robot.x - 1] = null;
        grid[B - ny][nx - 1] = robot;
        robot.x = nx;
        robot.y = ny;
        return move(robot, count - 1);
    }
}
