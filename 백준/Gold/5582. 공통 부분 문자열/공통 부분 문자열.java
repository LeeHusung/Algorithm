import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        char[] arr = A.toCharArray();
        char[] brr = B.toCharArray();
        int[][] dp;
        if (arr.length <= brr.length) {
            dp = new int[brr.length][arr.length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (i - 1 >= 0 && j - 1 >= 0 && brr[i] == arr[j] && dp[i - 1][j - 1] > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        continue;
                    }
                    if (brr[i] == arr[j]) {
                        dp[i][j]++;
                        continue;
                    }
                }
            }
            int answer = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    answer = Math.max(answer, dp[i][j]);
                }
            }
            System.out.println(answer);

        }
        else {
            dp = new int[arr.length][brr.length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (i - 1 >= 0 && j - 1 >= 0 && arr[i] == brr[j] && dp[i - 1][j - 1] > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        continue;
                    }
                    if (arr[i] == brr[j]) {
                        dp[i][j]++;
                        continue;
                    }
                }
            }
            int answer = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    answer = Math.max(answer, dp[i][j]);
                }
            }
            System.out.println(answer);

        }
    }
}
