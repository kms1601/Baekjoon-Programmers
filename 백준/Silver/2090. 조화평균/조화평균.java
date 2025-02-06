import java.io.*;
import java.math.BigInteger;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    static class Fraction {
        BigInteger p, q;

        public Fraction(BigInteger p, BigInteger q) {
            this.p = p;
            this.q = q;
        }

        public Fraction add(Fraction f) {
            BigInteger lcm = lcm(this.q, f.q);
            this.p = lcm.multiply(this.p).divide(this.q).add(lcm.multiply(f.p).divide(f.q));
            this.q = lcm;
            BigInteger gcd = gcd(this.p, this.q);
            this.p = this.p.divide(gcd);
            this.q = this.q.divide(gcd);
            return this;
        }

        private BigInteger gcd(BigInteger a, BigInteger b) {
            if (b.equals(BigInteger.ZERO)) return a;
            return gcd(b, a.mod(b));
        }

        private BigInteger lcm(BigInteger a, BigInteger b) {
            return a.multiply(b).divide(gcd(a, b));
        }

        public Fraction reverse() {
            BigInteger temp = this.p;
            this.p = this.q;
            this.q = temp;
            return this;
        }

        @Override
        public String toString() {
            return this.p + "/" + this.q;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(BR.readLine());
        String[] input = BR.readLine().split(" ");
        Fraction harmonic = new Fraction(BigInteger.ONE, new BigInteger(input[0]));
        for (int i = 1; i < N; i++) {
            BigInteger n = new BigInteger(input[i]);
            harmonic.add(new Fraction(BigInteger.ONE, n));
        }
        System.out.println(harmonic.reverse().toString());
    }
}
