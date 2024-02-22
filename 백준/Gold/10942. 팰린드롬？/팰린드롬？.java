import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i+1] = 1;
            }
        }
        for (int i = 1; i <= n - 2; i++) {
            if (arr[i] == arr[i + 2]) {
                dp[i][i+2] = 1;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (arr[j] != arr[j + i]) continue;
                if (dp[j+1][j+i-1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            sb.append(dp[x][y]).append("\n");
        }
        System.out.println(sb);


    }
}