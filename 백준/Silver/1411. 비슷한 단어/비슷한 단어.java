import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = normalize(BR.readLine());
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int result = 0;
        for (String s : map.keySet()) {
            int n = map.get(s);
            if (n == 1) continue;
            result += n * (n - 1) / 2;
        }
        System.out.println(result);
    }

    private static String normalize(String str) {
        StringBuilder result = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        char cur = 'a';
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, cur++);
            }
            result.append(map.get(c));
        }
        return result.toString();
    }
}
