import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int i = s.nextInt();
        System.out.println(str.charAt(i - 1));
        s.close();
    }
}
