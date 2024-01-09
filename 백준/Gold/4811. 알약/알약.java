import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[31][31];

        dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][1] = i;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) break;
            System.out.println(dp[x][x]);
        }


    }
}
