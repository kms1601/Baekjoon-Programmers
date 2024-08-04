import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "Cry";
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        String[] F = br.readLine().split(" ");
        int sum = Arrays.stream(F).mapToInt(Integer::parseInt).sum();

        if (sum >= T) {
            result = "Happy";
        }
        System.out.println("Padaeng_i " + result);
    }
}
