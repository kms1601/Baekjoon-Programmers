import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(s.nextInt() + s.nextInt());
        }
        s.close();
    }
}
