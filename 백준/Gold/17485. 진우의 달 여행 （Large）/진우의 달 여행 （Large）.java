import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n + 2][m];
        int[][][] dp = new int[n + 2][m][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], 1000001);
            }
        }
        for (int i = 0; i < m; i++) {
            dp[1][i][0] = arr[1][i];
            dp[1][i][1] = arr[1][i];
            dp[1][i][2] = arr[1][i];
        }

        for (int i = 2; i <= n + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
                } else if (j == m - 1) {
                    dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
                } else {
                   dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                   dp[i][j][1] = Math.min(dp[i - 1][j][2], dp[i - 1][j][0]) + arr[i][j];
                   dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, Math.min(dp[n][i][0], Math.min(dp[n][i][1], dp[n][i][2])));
        }
        System.out.println(min);

    }
}
