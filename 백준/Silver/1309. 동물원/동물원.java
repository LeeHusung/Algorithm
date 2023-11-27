import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(3);
            return;
        }
        if (n == 2) {
            System.out.println(7);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = 3;
        dp[2] = 7;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i-1] * 2 + dp[i - 2]) % 9901;
        }
        System.out.println(dp[n]);

    }
}
