class Solution {
    public int solution(String A, String B) {
        int len = A.length() - 1;
        int answer = 0;
        
        for (int i = 0; i <= len; i++) {
            if (A.equals(B)) return answer;
            A = A.substring(len, len + 1) + A.substring(0, len);
            answer++;
        }
        return -1;
    }
}