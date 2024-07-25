import java.util.*;

class Solution {
    public int solution(String s) {
        String originalS = s;
        String[] compressedArr = new String[s.length() / 2 + 1];
        compressedArr[0] = s;

        for (int i = 1; i <= originalS.length() / 2; i++) {
            s = originalS;
            StringBuilder compressed = new StringBuilder();
            while (s.length() >= i) {
                int repeat = compressing(s, i);
                compressed.append(repeat == 1 ? "" : repeat).append(s, 0, i);
                s = s.substring(i * repeat);
            }
            compressed.append(s);
            compressedArr[i] = compressed.toString();
        }
        Arrays.sort(compressedArr, Comparator.comparingInt(String::length));
        return compressedArr[0].length();
    }

    private int compressing(String s, int cut) {
        if (s.length() < cut || !s.substring(0, cut).equals(s.substring(cut, Math.min(2 * cut, s.length())))) {
            return 1;
        }
        return 1 + compressing(s.substring(cut), cut);
    }
}