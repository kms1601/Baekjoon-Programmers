import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    List<Integer> nums = new ArrayList<Integer>();
    int min = 501;
    while (st.hasMoreTokens()) {
      nums.add(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < 2; i++) {
      nums.add(nums.get(i));
      nums.add(Math.abs(nums.get(i) - nums.get(i + 2)));
    }
    
    for (int i = 4; i < 8; i++) {
      if (nums.get(i) < min) {
        min = nums.get(i);
      }
    }
    System.out.println(min);
  }
}
