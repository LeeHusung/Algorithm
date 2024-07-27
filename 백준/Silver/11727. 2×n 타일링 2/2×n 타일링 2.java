import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        long[] dp = new long[1001];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        dp[4] = 11;
        for (int i = 5; i < 1001; i++) {
            if (i % 2 == 1) {
                dp[i] = (dp[i - 1] * 2 - 1) % 10007;
            } else {
                dp[i] = (dp[i - 1] * 2 + 1) % 10007;
            }
        }
        System.out.println(dp[n]);

    }
}
