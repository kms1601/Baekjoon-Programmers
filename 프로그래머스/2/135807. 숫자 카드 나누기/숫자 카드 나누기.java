import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int aGcd = Arrays.stream(arrayA).reduce((a, b) -> gcd(a, b)).getAsInt();
        int bGcd = Arrays.stream(arrayB).reduce((a, b) -> gcd(a, b)).getAsInt();
        
        boolean aMatch = Arrays.stream(arrayB).anyMatch((b) -> b % aGcd == 0);
        boolean bMatch = Arrays.stream(arrayA).anyMatch((a) -> a % bGcd == 0);
        
        if (aMatch && bMatch)
            return 0;
        else if (bMatch)
            return aGcd;
        else if (aMatch)
            return bGcd;
        else
            return Math.max(aGcd, bGcd);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}