import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long answer;
    static int[] arr, ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0L;
        arr = new int[n];
        ch = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i-1][j] > 0) {
                    int plus = j + x;
                    int minus = j - x;
                    if (plus <= 20) dp[i][plus] += dp[i - 1][j];
                    if (minus >= 0) dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 2][arr[n-1]]);
    }
}
