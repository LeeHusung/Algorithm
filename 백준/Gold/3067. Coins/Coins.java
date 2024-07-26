import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(s[i - 1]);
            }
            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[m + 1];

            for (int i = 1; i <= n; i++) {
                dp[0] = 1;
                for (int j = arr[i]; j <= m; j++) {
                    dp[j] += dp[j - arr[i]];
                }
            }
            System.out.println(dp[m]);
        }
    }
}
