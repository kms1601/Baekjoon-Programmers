import java.io.*;
import java.util.*;

public class Main {
    static class GravityQueue {
        private Deque<Boolean> queue = new ArrayDeque<>();
        private int countBalls = 0;
        private int countWalls = 0;
        private int direction = 0;

        public void pushBall() {
            if (direction == 3 || direction == 1 && countWalls == 0) return;
            queue.addLast(false);
            countBalls++;
        }

        public void pushWall() {
            queue.addLast(true);
            countWalls++;
        }

        public void pop() {
            if (!queue.isEmpty()) {
                if (queue.pollFirst()) {
                    countWalls--;
                    handleFalling();
                } else {
                    countBalls--;
                }
            }
        }

        public void rotateLeft() {
            direction = direction == 0 ? 3 : direction - 1;
            handleFalling();
        }

        public void rotateRight() {
            direction = (direction + 1) % 4;
            handleFalling();
        }

        private void handleFalling() {
            switch (direction) {
                case 1:
                    while (!queue.isEmpty() && !queue.peekFirst()) {
                        queue.pollFirst();
                        countBalls--;
                    }
                    break;
                case 3:
                    while (!queue.isEmpty() && !queue.peekLast()) {
                        queue.pollLast();
                        countBalls--;
                    }
            }
        }

        public int getCountBalls() {
            return countBalls;
        }

        public int getCountWalls() {
            return countWalls;
        }
    }

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());

        StringTokenizer st;
        GravityQueue gravityQueue = new GravityQueue();
        StringBuilder result = new StringBuilder();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(BR.readLine());
            switch (st.nextToken()) {
                case "push":
                    switch (st.nextToken()) {
                        case "b":
                            gravityQueue.pushBall();
                            break;
                        case "w":
                            gravityQueue.pushWall();
                    }
                    break;
                case "pop":
                    gravityQueue.pop();
                    break;
                case "rotate":
                    switch (st.nextToken()) {
                        case "l":
                            gravityQueue.rotateLeft();
                            break;
                        case "r":
                            gravityQueue.rotateRight();
                    }
                    break;
                case "count":
                    switch (st.nextToken()) {
                        case "b":
                            result.append(gravityQueue.getCountBalls());
                            break;
                        case "w":
                            result.append(gravityQueue.getCountWalls());
                    }
                    result.append('\n');
            }
        }
        System.out.println(result);
    }
}
