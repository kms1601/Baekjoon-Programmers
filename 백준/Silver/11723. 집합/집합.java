import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        Set<String> set = new TreeSet<>();
        int M = Integer.parseInt(br.readLine());
        String x;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add":
                    x = st.nextToken();
                    set.add(x);
                    break;
                case "remove":
                    x = st.nextToken();
                    set.remove(x);
                    break;
                case "check":
                    x = st.nextToken();
                    sb.append(set.contains(x) ? 1 : 0);
                    sb.append("\n");
                    break;
                case "toggle":
                    x = st.nextToken();
                    if (set.contains(x)) {
                        set.remove(x);
                    } else {
                        set.add(x);
                    }
                    break;
                case "all":
                    set = new TreeSet<>(Arrays.
                            asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));
                    break;
                case "empty":
                    set.clear();
            }
        }
        System.out.println(sb);
    }
}
