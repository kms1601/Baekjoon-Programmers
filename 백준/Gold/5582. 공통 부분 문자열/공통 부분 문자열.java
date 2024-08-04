import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int str1L = str1.length();
        int str2L = str2.length();

        int[][] lcs = new int[str2.length() + 1][str1.length() + 1];
        int max = 0;
        for (int i = 1; i <= str2L; i++) {
            for (int j = 1; j <= str1L; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1))
                    lcs[i][j] += (lcs[i - 1][j - 1] + 1);
                max = Math.max(max, lcs[i][j]);
            }
        }
        System.out.println(max);
    }
}
