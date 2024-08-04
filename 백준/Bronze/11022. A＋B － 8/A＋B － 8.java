import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append("Case #" + i + ": " + a + " + " + b + " = " + (a + b) + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
