import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        BigInteger P = new BigInteger(s[0]);

        boolean result = false;
        int prime = 0;
        for (int i = 2; i < Integer.parseInt(s[1]); i++) {
            if (P.mod(new BigInteger(String.valueOf(i))).equals(BigInteger.ZERO)) {
                prime = i;
                result = true;
                break;
            }
        }
        if (result) {
            System.out.printf("BAD %d", prime);
        } else {
            System.out.println("GOOD");
        }
    }
}
