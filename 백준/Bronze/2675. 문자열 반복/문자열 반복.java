import java.io.*;
import java.util.StringTokenizer;;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      char[] s = st.nextToken().toCharArray();
      for (char c : s) {
        for (int j = 0; j < r; j++) {
          sb.append(c);
        }
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
    br.close();
  }
}
