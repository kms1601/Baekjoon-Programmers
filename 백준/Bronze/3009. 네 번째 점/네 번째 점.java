import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static int getOnlyOne(ArrayList<Integer> list) {
    if (list.get(0).equals(list.get(1))) {
      return list.get(2);
    } else if (list.get(0).equals(list.get(2))) {
      return list.get(1);
    } else {
      return list.get(0);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    ArrayList<Integer> arrX = new ArrayList<Integer>();
    ArrayList<Integer> arrY = new ArrayList<Integer>();
    for (int i = 0; i < 3; i++) {
      String[] str = s.nextLine().split(" ");
      arrX.add(Integer.parseInt(str[0]));
      arrY.add(Integer.parseInt(str[1]));
    }
    System.out.printf("%d %d", getOnlyOne(arrX), getOnlyOne(arrY));
  }
}
