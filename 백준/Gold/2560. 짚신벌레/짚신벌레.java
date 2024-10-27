import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        int n = Integer.parseInt(s[3]);
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i < a) {
                dp[i] = dp[i - 1] % 1000;
            }
            else if (i < b) {
                dp[i] = dp[i - 1] + dp[i - a] % 1000;
            } else {
                dp[i] = (dp[i - 1] + dp[i - a] - dp[i - b] + 1000) % 1000;
            }
        }

        if (n - d >= 0) {
            System.out.println((dp[n] - dp[n - d] + 1000) % 1000);
        } else {
            System.out.println(dp[n] % 1000);
        }

    }
}
