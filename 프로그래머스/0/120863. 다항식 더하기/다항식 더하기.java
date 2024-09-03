class Solution {
    public String solution(String polynomial) {
        String[] split = polynomial.replace("+", "").split("  ");
        int a = 0;
        int b = 0;
        for (String s : split) {
            if (s.charAt(s.length() - 1) == 'x') {
                if (s.length() == 1) {
                    a++;
                } else {
                    a += Integer.parseInt(s.substring(0, s.length() - 1));
                }
            } else {
                b += Integer.parseInt(s);
            }
        }
        
        String answer = "";
        if (a > 0) {
            if (a == 1) {
                answer += "x";
            } else {
                answer = a + "x";
            }
        }
        
        if (b > 0) {
            if (answer.length() == 0) {
                answer += b;
            } else {
                answer += " + " + b;
            }
        }
        return answer;
    }
}