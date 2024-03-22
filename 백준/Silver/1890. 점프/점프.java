import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] > 0) {
                    if (arr[i][j] == 0) continue;
                    if (i + arr[i][j] <= n) dp[i + arr[i][j]][j] += dp[i][j];
                    if (j + arr[i][j] <= n) dp[i][j + arr[i][j]] += dp[i][j];
                }

            }
        }
        System.out.println(dp[n][n]);
    }
}