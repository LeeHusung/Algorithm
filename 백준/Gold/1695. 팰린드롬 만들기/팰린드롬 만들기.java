import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                if (arr[j] == arr[j + i]) {
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                } else {
                    dp[j][j + i] = Math.min(dp[j+1][j+i], dp[j][j+i-1]) + 1;
                }
            }
        }
        System.out.println(dp[1][n]);

    }
}
