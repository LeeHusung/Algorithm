import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, cnt, max;
    static int[][] arr, dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        cnt = 1;
        max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D(i, j);
                max = Math.max(max, dp[i][j]);
                cnt = 1;
            }
        }

        System.out.println(max);

    }

    private static int D(int x, int y) {
        if (dp[x][y] > 0) return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] > arr[x][y]) {
                dp[x][y] = Math.max(dp[x][y], D(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}
