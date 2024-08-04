import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> remains = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int remain = Integer.parseInt(br.readLine()) % 42;
            if (!remains.contains(remain)) {
                remains.add(remain);
            }
        }
        System.out.println(remains.size());
        br.close();
    }
}
