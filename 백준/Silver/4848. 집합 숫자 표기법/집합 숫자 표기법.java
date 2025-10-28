import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static int toInt(String set) {
        int count = 0;
        int index = set.length() - 1;
        while (set.charAt(index--) == '}') count++;
        return count - 1;
    }

    private static String toSet(int i) {
        if (i == 0) return "{}";
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int j = 0; j < i; j++) {
            sb.append(toSet(j));
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(BR.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String a = BR.readLine();
            String b = BR.readLine();
            sb.append(toSet(toInt(a) + toInt(b))).append('\n');
        }
        System.out.println(sb.toString().strip());
    }
}
