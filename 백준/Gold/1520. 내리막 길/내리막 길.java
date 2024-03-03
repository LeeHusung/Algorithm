import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int[][] arr, dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;
    private static int D(int x, int y) {
        if (x == n-1 && y == m-1) {
            return 1;
        }
        if (dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (arr[nx][ny] < arr[x][y]) {
                dp[x][y] += D(nx, ny);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
                dp[i][j] = -1;
            }
        }
        System.out.println(D(0, 0));
    }
}