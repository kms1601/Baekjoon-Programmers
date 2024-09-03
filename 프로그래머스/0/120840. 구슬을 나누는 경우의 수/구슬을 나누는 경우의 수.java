import java.math.*;

class Solution {
    private final BigInteger ONE = BigInteger.ONE;
    
    public int solution(int balls, int share) {
        BigInteger a = factorial(BigInteger.valueOf(balls));
        BigInteger b = factorial(BigInteger.valueOf(balls - share));
        BigInteger c = factorial(BigInteger.valueOf(share));
        return a.divide(b.multiply(c)).intValue();
    }
    
    private BigInteger factorial(BigInteger n) {
        if (n.compareTo(ONE) <= 0) return ONE;
        return n.multiply(factorial(n.subtract(ONE)));
    }
}