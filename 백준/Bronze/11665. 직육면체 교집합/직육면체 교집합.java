import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int maxX1 = 1, maxY1 = 1, maxZ1 = 1;
        int minX2 = 1000, minY2 = 1000, minZ2 = 1000;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            maxX1 = Math.max(maxX1, Integer.parseInt(st.nextToken()));
            maxY1 = Math.max(maxY1, Integer.parseInt(st.nextToken()));
            maxZ1 = Math.max(maxZ1, Integer.parseInt(st.nextToken()));

            minX2 = Math.min(minX2, Integer.parseInt(st.nextToken()));
            minY2 = Math.min(minY2, Integer.parseInt(st.nextToken()));
            minZ2 = Math.min(minZ2, Integer.parseInt(st.nextToken()));
        }
        
        int x = (minX2 - maxX1);
        int y = (minY2 - maxY1);
        int z = (minZ2 - maxZ1);
        if (x >= 0 && y >= 0 && z >= 0) {
            System.out.println(x * y * z);
        } else {
            System.out.println(0);
        }
    }
}
