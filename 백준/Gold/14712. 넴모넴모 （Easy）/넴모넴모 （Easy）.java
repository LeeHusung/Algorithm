import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m, cnt;
    static int[][] arr;
    static int[] dx = {-1, 0, -1};
    static int[] dy = {0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        cnt = 0;
        D(0, 0);
        System.out.println(cnt);

    }

    private static void D(int x, int y) {
        if (x == n - 1 && y == m) {
            cnt++;
            return;
        }
        if (y >= m) {
            y = 0;
            x++;
        }
        arr[x][y] = 1;
        if(check(x, y)) D(x, y + 1);
        arr[x][y] = 0;
        D(x, y + 1);

    }

    private static boolean check(int x, int y) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1) k++;
        }
        if (k == 3) return false;
        return true;
    }
}
