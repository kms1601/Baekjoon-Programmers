import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            String str = s.next();
            System.out.println("" + str.charAt(0) + str.charAt(str.length() - 1));
        }
        s.close();
    }
}
