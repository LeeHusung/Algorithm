import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int n = sc.nextInt();
            double m = sc.nextDouble();
            if (n == 0) break;

            int mm = 0, pp = 0;
            int[] dp = new int[(int) Math.round(m * 100) + 1];
            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                double p = sc.nextDouble();
                mm = (int) Math.round(m * 100);
                pp = (int) Math.round(p * 100);

                for (int j = pp; j <= mm; j++) {
                    dp[pp] = c;
                    if (dp[pp] + dp[j - pp] >= dp[j]) {
                        dp[j] = dp[pp] + dp[j - pp];
                    }
                }

            }
            System.out.println(dp[mm]);
        }

    }
}
