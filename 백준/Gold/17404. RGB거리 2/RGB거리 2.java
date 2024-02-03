import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][0] = arr[1][0];

        int answer = Integer.MAX_VALUE;
        for (int i = 2; i < n + 1; i++) {
            if (dp[i-1][1] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            }
            if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            }
            if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][1] != Integer.MAX_VALUE) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) continue;
            answer = Math.min(dp[n][i], answer);
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = arr[1][1];

        for (int i = 2; i < n + 1; i++) {
            if (dp[i-1][1] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            }
            if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            }
            if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][1] != Integer.MAX_VALUE) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (i == 1) continue;
            answer = Math.min(dp[n][i], answer);
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[1][2] = arr[1][2];

        for (int i = 2; i < n + 1; i++) {
            if (dp[i-1][1] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            }
            if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][2] != Integer.MAX_VALUE) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            }
            if (dp[i-1][0] != Integer.MAX_VALUE || dp[i-1][1] != Integer.MAX_VALUE) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (i == 2) continue;
            answer = Math.min(dp[n][i], answer);
        }

        System.out.println(answer);
    }
}
