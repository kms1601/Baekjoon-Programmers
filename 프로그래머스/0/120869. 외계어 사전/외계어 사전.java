class Solution {
    public int solution(String[] spell, String[] dic) {
        loop:
        for (String word : dic) {
            for (String letter : spell) {
                String temp = word.replaceFirst(letter, "");
                if (word.equals(temp)) continue loop;
                word = temp;
            }
            
            if (word.length() == 0) return 1;
        }
        return 2;
    }
}