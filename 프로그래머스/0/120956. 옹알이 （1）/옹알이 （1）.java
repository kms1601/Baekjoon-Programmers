class Solution {
    private final String[] list = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (String bab : babbling) {
            for (String s : list) {
                bab = bab.replaceFirst(s, " ");
            }
            if (bab.trim().length() == 0) answer++;
        }
        return answer;
    }
}