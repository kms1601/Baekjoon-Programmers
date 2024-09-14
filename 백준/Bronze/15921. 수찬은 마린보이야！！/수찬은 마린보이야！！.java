import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        if (N == 0) {
            System.out.println("divide by zero");
            return;
        }

        boolean flag = false;
        st = new StringTokenizer(BR.readLine());
        for (int i = 0; i < N; i++) {
            if (!st.nextToken().equals("0")) flag = true;
        }

        if (flag) {
            System.out.println("1.00");
        } else {
            System.out.println("divide by zero");
        }
    }
}
