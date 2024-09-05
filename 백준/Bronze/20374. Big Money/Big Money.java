import java.io.*;
import java.math.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = "";
        BigDecimal sum = BigDecimal.ZERO;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            sum = sum.add(new BigDecimal(input));
        }
        System.out.println(sum);
    }
}
