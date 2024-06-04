import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] dp = new int[s.length() + 1];
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (dp[j] == 1 && list.contains(s.substring(i, j))) {
                    dp[i] = 1;
                }
            }
            if (list.contains(s.substring(i))) {
                dp[i] = 1;
            }
        }
        if (dp[0] == 1) System.out.println(1);
        else System.out.println(0);

    }
}
