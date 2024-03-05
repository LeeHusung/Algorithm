import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][11];

        if (n == 1) {
            System.out.println(10);
            return;
        }
        if (n == 2) {
            System.out.println(55);
            return;
        }
        int x = 10;
        for (int i = 1; i <= 10; i++) {
            dp[2][i] = x--;
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = j; k <= 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }
        long answer = 0;
        for (int i = 1; i <= 10; i++) {
            answer += dp[n][i];
        }
        answer %= 10007;
        System.out.println(answer);
    }
}