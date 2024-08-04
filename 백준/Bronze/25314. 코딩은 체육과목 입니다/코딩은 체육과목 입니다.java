import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        n /= 4;
        for (int i = 0; i < n; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
        s.close();
    }
}
