import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[][] arr;
    static long[][][] dp;

    private static long D() {
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (arr[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                if (i == 1) continue;
                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                if (arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
        return dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n + 1][n + 1];
        dp = new long[n + 1][n + 1][3]; //3 = 가로, 세로, 대각선
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        if (arr[1][2] == 1) {
            System.out.println(0);
            return;
        }

        dp[1][2][0] = 1; //1행 2열 가로 = 1;

        if (arr[n][n] == 1) {
            System.out.println(0);
        } else {
            System.out.println(D());
        }

    }


}
