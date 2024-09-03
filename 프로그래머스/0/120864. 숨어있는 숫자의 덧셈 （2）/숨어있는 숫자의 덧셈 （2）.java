class Solution {
    public int solution(String my_string) {
        String[] split = my_string.split("[A-Za-z]{1,}");
        int answer = 0;
        for (String s : split) {
            if (s.length() == 0) continue;
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}