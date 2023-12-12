import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int C = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);

        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            int cost = Integer.parseInt(s1[0]);
            int getCustomers = Integer.parseInt(s1[1]);

            for (int j = getCustomers; j <= C + 100; j++) {
                if (dp[j - getCustomers] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - getCustomers] + cost);
                }
            }
        }
        int answer = dp[C];
        for (int i = C; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
//40%에서 틀렸습니다
//        int[] dp = new int[10001];
//        for (int i = 0; i < N; i++) {
//            String[] s1 = br.readLine().split(" ");
//            int cost = Integer.parseInt(s1[0]);
//            int getCustomers = Integer.parseInt(s1[1]);
//
//            if (N == 1) {
//                System.out.println(C / getCustomers * cost);
//                return;
//            }
//            for (int j = cost; j < dp.length; j++) {
//                dp[j] = Math.max(dp[j], dp[j - cost] + getCustomers);
//            }
//        }
//
//        for (int i = 0; i < dp.length; i++) {
//            if (dp[i] >= C) {
//                answer = i;
//                break;
//            }
//        }
//        System.out.println(answer);

