import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String si = st.nextToken();
            int index = si.indexOf('X');
            if (index == -1) index = si.indexOf('x');

            sb.append(Character.toUpperCase(st.nextToken().charAt(index)));
        }
        System.out.println(sb);
    }
}
