import java.io.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            count = 0;
            System.out.println(isPalindrome(br.readLine()) + " " + count);
        }
    }

    private static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    private static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) return 1;
        if (s.charAt(l) != s.charAt(r)) return 0;
        return recursion(s, l + 1, r - 1);
    }
}
