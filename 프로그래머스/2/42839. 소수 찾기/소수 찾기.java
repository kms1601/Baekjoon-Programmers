import java.util.*;

class Solution {
    Set<Integer> permutation = new HashSet<>();
    String numbers;
    int n;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        this.n = numbers.length();
        
        for (int i = 1; i <= numbers.length(); i++)
            permutation(new StringBuilder(), new boolean[n], i, 0);
        return (int) permutation.stream()
            .filter((i) -> isPrime(i))
            .count();
    }
    
    private void permutation(StringBuilder sb, boolean[] visit, int r, int depth) {
        if (depth == r) {
            permutation.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            sb.append(numbers.charAt(i));
            permutation(sb, visit, r, depth + 1);
            visit[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}