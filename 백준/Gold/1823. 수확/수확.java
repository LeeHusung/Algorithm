import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) dp[i][i] = arr[i];
//
//        int[] s = new int[n + 1];
//        int c = 0;
//        for (int i = 1; i < s.length; i++) {
//            c += arr[i];
//            s[i] = c;
//        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n-i; j++) {
                int cnt = 0;
                for (int k = j; k <= j + i; k++) {
                    cnt += arr[k];
                }
                dp[j][j+i] = Math.max(dp[j][j+i-1], dp[j+1][j+i]) + cnt;
            }
        }

        System.out.println(dp[1][n]);
    }
}
