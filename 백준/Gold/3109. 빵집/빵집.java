import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] arr, ch;
    static boolean flag = false;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {-1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'x') arr[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            ch[i][m-1] = 1;
            D(i, m - 1);
            flag = false;
        }
        System.out.println(k);

    }

    private static void D(int x, int y) {
        if (flag) return;
        if (y == 0) {
            k++;
            flag = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == 0) {
                ch[nx][ny] = 1;
                D(nx, ny);
                if (flag) return;
            }
        }
    }
}
