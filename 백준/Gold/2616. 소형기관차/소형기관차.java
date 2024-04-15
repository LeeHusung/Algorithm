import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] sum = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sum[1] = Long.parseLong(st.nextToken());
                continue;
            }
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }

        int maxTrain = Integer.parseInt(br.readLine());
        long[][] dp = new long[4][n + 1];

        for (int i = 1; i < 4; i++) {
            for (int j = i * maxTrain; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - maxTrain] + sum[j] - sum[j - maxTrain]);
            }
        }
        System.out.println(dp[3][n]);
    }
}
