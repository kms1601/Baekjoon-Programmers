import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> chats = new HashSet<>();
        int answer = 0;
        for (int n = 0; n < N; n++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                chats = new HashSet<>();
                continue;
            }

            if (!chats.contains(chat)) {
                chats.add(chat);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
