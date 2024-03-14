import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] memory = new int[n + 1];
        int[] cost = new int[n + 1];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(s2[i]);
        }

        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[n + 1][100001];
        for (int i = 0; i < n; i++) {
            int x = memory[i];
            int c = cost[i];
            for (int j = 0; j < 100000; j++) {
                if (i == 0) {
                    if (j >= c) dp[i][j] = x;
                } else {
                    if (j >= c) {
                        dp[i][j] = Math.max(dp[i - 1][j - c] + x, dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= m) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);

    }
}
