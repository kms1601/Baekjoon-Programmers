import java.io.*;

public class Main {
    static final byte[] isPrime = new byte[246913];

    public static void main(String[] args) throws IOException {
        setIsPrime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) break;

            int count = 0;
            for (int i = input + 1; i <= input * 2; i++) {
                if (isPrime[i] == 0) count++;
            }
            System.out.println(count);
        }
    }

    private static void setIsPrime() {
        isPrime[0] = isPrime[1] = 2;
        for (int i = 2; i <= 497; i++) {
            if (isPrime[i] == 2) continue;

            for (int j = i * 2; j < 246913; j += i) {
                isPrime[j] = 2;
            }
        }
    }
}
