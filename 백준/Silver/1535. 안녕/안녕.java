import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n + 1];
        int[][] dp = new int[n + 1][100];
        String[] lose = br.readLine().split(" ");
        String[] get = br.readLine().split(" ");

        for (int i = 1; i < n + 1; i++) {
            int idx = 0;
            arr[idx++][i] = Integer.parseInt(lose[i - 1]);
            arr[idx][i] = Integer.parseInt(get[i - 1]);
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 100; j++) {
                if (j < arr[0][i]) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[0][i]] + arr[1][i]);
                }
            }
        }
        System.out.println(dp[n][99]);
    }
}