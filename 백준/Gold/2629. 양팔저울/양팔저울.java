import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] choo = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            choo[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][40001];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 40001; j++) {
                if (dp[i - 1][j] != 0) {
                    dp[i][j] = 1;
                    if (j + choo[i] < 40001) dp[i][j + choo[i]] = 1;
                    if (Math.abs(j - choo[i]) >= 0) dp[i][Math.abs(j - choo[i])] = 1;
                }
            }
        }

        int cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= cnt; i++) {
            int check = Integer.parseInt(st.nextToken());
            if (dp[n][check] == 1) {
                sb.append("Y").append(" ");
                continue;
            }
            sb.append("N").append(" ");
        }
        System.out.println(sb);
    }
}
