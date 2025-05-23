import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            if (max != 0) {
                dp[i] = max + 1;
            } else {
                dp[i] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

    }
}
