import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n + 1];
        long[] dp = new long[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            dp[i] = arr[i];
        }

        for (int i = 1; i <= n; i++) {
            long x = arr[i];
            long p = 0;
            for (int j = i - 1; j >= 1; j--) {
                if (x > arr[j]) {
                    p = Math.max(p, dp[j]);
                }
            }
            dp[i] = p + dp[i];
        }
        long max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
