import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) print(br.readLine(), t);
    }

    private static void print(String country, int t) {
        String end = "";
        switch (country.charAt(country.length() - 1)) {
            case 'a', 'e', 'i', 'o', 'u':
                end = "a queen";
                break;
            case 'y':
                end = "nobody";
                break;
            default:
                end = "a king";
        }
        System.out.printf("Case #%d: %s is ruled by %s.%n", t, country, end);
    }
}
