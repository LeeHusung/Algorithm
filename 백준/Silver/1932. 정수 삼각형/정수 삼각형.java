import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[n][n];
        int[][] arr = new int[n][n];

        int cnt = 0;
        for (int i = n; i > 0; i--) {
            cnt += i;
        }

        int x = 0;
        int y = 0;
        int c = 0;
        int idx = 1;
        for (int i = 0; i < cnt; i++) {
            int z = sc.nextInt();
            arr[x][y] = z;
            c++;
            y++;
            if (c == idx) {
                idx++;
                x++;
                y = 0;
                c = 0;
            }
        }

        dp[0][0] = arr[0][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + arr[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            int max = dp[n - 1][i];
            if (max > answer) {
                answer = max;
            }
        }
        System.out.println(answer);

    }
}
