import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, max;
    static int[][] arr,ch;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        ch = new int[n][m];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        D(0, 0, 0, 0);
        System.out.println(max);
    }

    private static void D(int L, int x, int y, int sum) {
        if (L == k) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                if (ch[i][j] == 0) {
                    if (check(i, j)) {
                        ch[i][j] = 1;
                        D(L + 1, x, y, sum + arr[i][j]);
                        ch[i][j] = 0;
                    }
                }
            }
        }

    }

    private static boolean check(int x, int y) {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 1) {
                return false;
            }
        }
        return true;
    }
}
