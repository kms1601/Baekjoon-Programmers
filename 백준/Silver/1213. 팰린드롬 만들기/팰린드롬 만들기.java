import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = BR.readLine();
        int len = str.length();
        int[] alpha = new int[26];
        char[] pelin = new char[len];
        for (int i = 0; i < len; i++) {
            alpha[str.charAt(i) - 'A']++;
        }
        int index = 0;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'A');
            while (alpha[i] > 1) {
                pelin[index] = pelin[len - index - 1] = ch;
                index++;
                alpha[i] -= 2;
            }

            if (alpha[i] == 1) {
                if (mid == 0 && len % 2 == 1) {
                    mid = ch;
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }
        pelin[index] = len % 2 == 1 ? mid : pelin[index];
        System.out.println(new String(pelin));
    }
}
