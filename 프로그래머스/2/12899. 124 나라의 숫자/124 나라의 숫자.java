class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 3) {
            switch (n % 3) {
                case 0:
                    sb.append('4');
                    n--;
                    break;
                case 1:
                    sb.append('1');
                    break;
                case 2:
                    sb.append('2');
            }
            n /= 3;
        }
        
        switch (n) {
            case 1:
                sb.append('1');
                break;
            case 2:
                sb.append('2');
                break;
            case 3:
                sb.append('4');
        }
        
        return sb.reverse().toString();
    }
}