import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            
            int[][] arr = new int[2][n];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            if (n == 1) {
                if (arr[0][0] > arr[1][0]) {
                    System.out.println(arr[0][0]);
                    continue;
                } else {
                    System.out.println(arr[1][0]);
                    continue;
                }
            }
            int[][] dp = new int[2][n];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }
            int max = 0;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    max = Math.max(max, dp[j][k]);
                }
            }

            System.out.println(max);
        }


    }
}
