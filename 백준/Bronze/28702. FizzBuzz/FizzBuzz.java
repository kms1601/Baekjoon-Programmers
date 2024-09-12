import java.io.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = "";
        for (int i = 0; i < 3; i++) {
            input = BR.readLine();
            try {
                int next = Integer.parseInt(input) + 3 - i;
                StringBuilder sb = new StringBuilder();
                sb.append(next % 3 == 0 ? "Fizz" : "");
                sb.append(next % 5 == 0 ? "Buzz" : "");
                System.out.println(sb.isEmpty() ? next : sb);
                break;
            } catch (NumberFormatException e) {}
        }
    }
}
