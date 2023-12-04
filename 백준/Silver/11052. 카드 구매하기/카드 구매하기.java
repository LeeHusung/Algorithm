import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = arr[i];
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
