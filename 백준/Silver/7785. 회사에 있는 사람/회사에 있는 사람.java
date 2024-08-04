import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> company = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String doing = st.nextToken();

            if (doing.equals("enter")) {
                company.add(name);
            } else {
                company.remove(name);
            }
        }
        ArrayList<String> inCompany = new ArrayList<String>(company);
        Collections.sort(inCompany);

        for (int i = inCompany.size() - 1; i >= 0 ; i--) {
            System.out.println(inCompany.get(i));
        }
        br.close();
    }
}
