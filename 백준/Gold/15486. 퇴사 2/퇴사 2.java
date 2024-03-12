import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n + 1];
        int[] cost = new int[n + 1];

        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            time[i] = Integer.parseInt(s[0]);
            cost[i] = Integer.parseInt(s[1]);
        }

        int answer = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
            int next = i + time[i];
            if (next < n + 2) {
                dp[next] = Math.max(dp[next], max + cost[i]);
                answer = Math.max(answer, dp[next]);
            }
        }
        System.out.println(answer);

    }
}