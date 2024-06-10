import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        if (arr[1][2] == 1) {
            System.out.println(0);
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 1, 1, 2});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            dp[p[2]][p[3]]++;
            //가로
            if (p[0] == p[2]) {
                if (p[1] + 1 <= n && p[3] + 1 <= n && arr[p[2]][p[3] + 1] == 0) {
                    q.offer(new int[]{p[0], p[1] + 1, p[2], p[3] + 1});
                    dp[p[2]][p[3]]++;
                }
                if (p[2] + 1 <= n && p[3] + 1 <= n && arr[p[2] + 1][p[3] + 1] == 0 && arr[p[2] + 1][p[3]] == 0 && arr[p[2]][p[3] + 1] == 0) {
                    q.offer(new int[]{p[0], p[1] + 1, p[2] + 1, p[3] + 1});
                    dp[p[2]][p[3]]++;
                }
            }
            //세로
            else if (p[1] == p[3]) {
                if (p[0] + 1 <= n && p[2] + 1 <= n && arr[p[2] + 1][p[3]] == 0) {
                    q.offer(new int[]{p[0] + 1, p[1], p[2] + 1, p[3]});
                    dp[p[2]][p[3]]++;
                }
                if (p[2] + 1 <= n && p[3] + 1 <= n && arr[p[2]][p[3]] == 0 && arr[p[2] + 1][p[3] + 1] == 0 && arr[p[2] + 1][p[3]] == 0 && arr[p[2]][p[3] + 1] == 0) {
                    q.offer(new int[]{p[0] + 1, p[1], p[2] + 1, p[3] + 1});
                    dp[p[2]][p[3]]++;
                }
            }
            else {
                if (p[1] + 1 <= n && p[3] + 1 <= n && arr[p[2]][p[3] + 1] == 0) {
                    q.offer(new int[]{p[0] + 1, p[1] + 1, p[2], p[3] + 1});
                    dp[p[2]][p[3]]++;
                }
                if (p[1] + 1 <= n && p[2] + 1 <= n && arr[p[2] + 1][p[3]] == 0) {
                    q.offer(new int[]{p[0] + 1, p[1] + 1, p[2] + 1, p[3]});
                    dp[p[2]][p[3]]++;
                }
                if (p[2] + 1 <= n && p[3] + 1 <= n && arr[p[2] + 1][p[3] + 1] == 0 && arr[p[2] + 1][p[3]] == 0 && arr[p[2]][p[3] + 1] == 0) {
                    q.offer(new int[]{p[0] + 1, p[1] + 1, p[2] + 1, p[3] + 1});
                    dp[p[2]][p[3]]++;
                }
            }
        }
        System.out.println(dp[n][n]);

    }
}
