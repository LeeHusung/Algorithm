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
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n) dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + arr[i + 1][j]);
                if (j + 1 < m) dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + arr[i][j + 1]);
                if (i + 1 < n && j + 1 < m) dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + arr[i + 1][j + 1]);
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
