import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]))  + arr[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + arr[i][2];
        }

        StringBuilder sb = new StringBuilder();
        int max = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
        sb.append(max).append(" ");

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][2];
        }

        int min = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        sb.append(min);
        System.out.println(sb);

    }
}
