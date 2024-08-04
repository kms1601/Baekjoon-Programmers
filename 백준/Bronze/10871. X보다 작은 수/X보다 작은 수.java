import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int x = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        for (String nums : input2) {
            int numi = Integer.parseInt(nums);
            if (x > numi) {
                System.out.print(numi + " ");
            }
        }
    }
}
