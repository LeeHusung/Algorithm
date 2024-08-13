import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int h = Integer.parseInt(s[2]);
        int[][] arr = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][h + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = 1;
            while (st.hasMoreTokens()) {
                arr[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= h; j++) {
                for (int k = 1; k <= m; k++) {
                    int x = arr[i][k];
                    if (x == 0) break;
                    if (j - x >= 0) {
                        dp[i][j] += dp[i-1][j - x] % 10007;
                    }
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;

            }
        }

        System.out.println(dp[n][h]);






    }
}
