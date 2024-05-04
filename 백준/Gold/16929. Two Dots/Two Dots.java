import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static char[][] arr;
    static int[][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new char[n][m];
        ch = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ch = new int[n][m];
                if (ch[i][j] == 0) {
                    ch[i][j] = 1;
                    D(1, i, j, i, j, arr[i][j]);
                }
            }
        }
        System.out.println("No");
    }

    private static void D(int L, int x, int y, int startX, int startY, char c) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == c) {
                cnt++;
            }
        }
        if (cnt >= 2) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (L >= 4 && nx == startX && ny == startY) {
                    System.out.println("Yes");
                    System.exit(0);
                }
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == c) {
                    ch[nx][ny] = 1;
                    D(L + 1, nx, ny, startX, startY, c);
                }
            }
        }
    }
}
