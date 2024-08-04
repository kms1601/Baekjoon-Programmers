import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> tracks = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            tracks.put(str[0], Integer.parseInt(str[1]));
        }
        int jinju = tracks.remove("jinju");
        System.out.println(jinju);
        int count = 0;

        for (String s : tracks.keySet()) {
            if (tracks.get(s) > jinju) {
                count++;
            }
        }
        System.out.println(count);
    }
}
