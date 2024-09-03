class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int N = board[0] / 2;
        int M = board[1] / 2;
        int x = 0;
        int y = 0;
        
        for (String input : keyinput) {
            switch (input) {
                case "up":
                    if (y + 1 <= M) {
                        y++;
                    }
                    break;
                case "down":
                    if (y - 1 >= -M) {
                        y--;
                    }
                    break;
                case "left":
                    if (x - 1 >= -N) {
                        x--;
                    }
                    break;
                case "right":
                    if (x + 1 <= N) {
                        x++;
                    }
            }
        }
        return new int[]{x, y};
    }
}