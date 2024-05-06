import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        long[][] dp = new long[2][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long answer = Integer.parseInt(st.nextToken());
        dp[0][1] = answer;
        dp[1][1] = answer;

        for (int i = 2; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[0][i] = Math.max(dp[0][i - 1] + arr[i], arr[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
            answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
        }
        System.out.println(answer);

    }
}
