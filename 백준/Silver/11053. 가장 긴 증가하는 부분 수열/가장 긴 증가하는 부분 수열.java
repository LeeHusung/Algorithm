import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int cur = arr[i];
            for (int j = 0; j < i; j++) {
                if (cur > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int answer = 0;
        for (int x : dp) {
            answer = Math.max(answer, x);
        }

        System.out.println(answer);
    }
}
