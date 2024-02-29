import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            int[] sum = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + arr[j];
            }

            for (int j = 1; j < n; j++) {
                for (int k = 1; k <= n - j; k++) {
                    int l = j + k;
                    dp[k][l] = Integer.MAX_VALUE;
                    for (int mid = k; mid < l; mid++) {
                        dp[k][l] = Math.min(dp[k][l], dp[k][mid] + dp[mid + 1][l] + sum[l] - sum[k - 1]);
                    }
                }
            }

            System.out.println(dp[1][n]);

        }
    }
}