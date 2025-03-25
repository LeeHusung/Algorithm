import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(s1[j - 1]);
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(arr[1][1]);
            return;
        }
        int[][] dp = new int[n + 1][m + 2];
        for (int i = 1; i <= m; i++) {
            dp[1][i] = dp[1][i - 1] + arr[1][i];
        }

        for (int i = 2; i <= n; i++) {
            //좌, 위
            int[] tmp = new int[m + 2];
            for (int j = 0; j < m + 2; j++) {
                tmp[j] = Integer.MIN_VALUE;
            }
            for (int j = 1; j <= m; j++) {
                tmp[j] = Math.max(dp[i - 1][j], tmp[j - 1]) + arr[i][j];
            }
//            System.out.println("좌,위:" + Arrays.toString(tmp));

            //우, 위
            int[] tmp2 = new int[m + 2];
            for (int j = 0; j < m + 2; j++) {
                tmp2[j] = Integer.MIN_VALUE;
            }
            for (int j = m; j >= 1; j--) {
                tmp2[j] = Math.max(dp[i - 1][j], tmp2[j + 1]) + arr[i][j];
            }
//            System.out.println("우,위:" + Arrays.toString(tmp2));
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(tmp[j], tmp2[j]);
            }
//            System.out.println("---------------");
//            for (int[] x : dp) {
//                for (int q : x) {
//                    System.out.print(q + " ");
//                }
//                System.out.println();
//            }
        }

        System.out.println(dp[n][m]);
    }
}
