import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k + 1];
        if (n == 1 && k == 1) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            if (w == 1) {
                System.out.println(v);
                return;
            } else {
                System.out.println(0);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            for (int j = k; j-w >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}