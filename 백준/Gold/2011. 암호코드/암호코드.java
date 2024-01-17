import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.startsWith("0")) {
            System.out.println(0);
            return;
        }
        int n = input.length();
        String[] arr = new String[n + 1];
        long[] dp = new long[n + 1];
        char[] carr = input.toCharArray();
        for (int i = 1; i < n + 1; i++) {
            arr[i] = String.valueOf(carr[i - 1]);
        }

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int current = Integer.parseInt(arr[i]);
            int previous = Integer.parseInt(arr[i - 1]) * 10 + current;

            if (current >= 1 && current <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }
            if (previous >= 10 && previous <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }


        System.out.println(dp[n]);


        // 30, 40, 50 ... 나오면 0 리턴

        //그리디인줄 알았으나, DP였다니 ......




    }
}