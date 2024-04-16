import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a > b) continue;
            arr[a][b] = Math.max(arr[a][b], c);
        }
        for (int i = 1; i <= n; i++) {
            dp[2][i] = arr[1][i];
        }

        for (int i = 2; i <= n; i++) { //출발
            for (int j = i + 1; j <= n; j++) { //도착
                for (int l = 2; l < m; l++) { //경유
                    if (dp[l][i] != 0 && arr[i][j] != 0) {
                        dp[l + 1][j] = Math.max(dp[l + 1][j], dp[l][i] + arr[i][j]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            answer = Math.max(answer, dp[i][n]);
        }
        System.out.println(answer);

    }
}
