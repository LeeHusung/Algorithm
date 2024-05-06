import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        long answer = -1001;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + x, x);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

    }
}
