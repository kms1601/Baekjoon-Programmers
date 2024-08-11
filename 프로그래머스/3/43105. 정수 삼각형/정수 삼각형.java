import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int h = 1; h < triangle.length; h++) {
            triangle[h][0] += triangle[h - 1][0];
            for (int w = 1; w < h; w++) {
                triangle[h][w] += Math.max(triangle[h - 1][w - 1], triangle[h - 1][w]);
            }
            triangle[h][h] += triangle[h - 1][h - 1];
        }
        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}