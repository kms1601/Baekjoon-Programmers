import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = s.nextInt();
        int receipt = 0;
        for (int i = s.nextInt(); i > 0; i--) {
            receipt += s.nextInt() * s.nextInt();
        }

        if (sum == receipt) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        s.close();
    }
}
