import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int cnt = 1;
        for (int i = 5; i <= n; i+=5) {
            dp[i] = Math.min(dp[i], cnt++);
        }

        cnt = 1;
        for (int i = 3; i <= n; i++) {
            if (dp[i - 3] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i-3] + 1);
            else {
                if (i % 3 == 0) dp[i] = Math.min(dp[i], cnt++);
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();
        if (dp[n] == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }
        System.out.println(dp[n]);
    }
}
