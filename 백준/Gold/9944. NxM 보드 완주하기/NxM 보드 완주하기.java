import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    static int[][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int res;
    static int idx;
    private static void D(int x, int y, int cnt, int dir) {
        if (check()) {
            res = Math.min(res, cnt);
            return;
        }
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m || ch[nx][ny] == 1 || arr[nx][ny] == '*') {
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == '.') {
                    ch[nx][ny] = 1;
                    D(nx, ny, cnt + 1, i);
                    ch[nx][ny] = 0;
                }
            }
            return;
        }
        ch[nx][ny] = 1;
        D(nx, ny, cnt, dir);
        ch[nx][ny] = 0;
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '.' && ch[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        idx = 1;
        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(s, " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            res = 1000001;
            arr = new char[n][m];
            ch = new int[n][m];
            int o = 0;
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == '.') o++;
                }
            }
            if (o == 1) {
                sb.append("Case ").append(idx++).append(": ").append(0).append("\n");
                continue;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == '.') {
                        for (int k = 0; k < 4; k++) {
                            ch[i][j] = 1;
                            D(i, j, 0, k);
                            ch[i][j] = 0;
                        }
                    }
                }
            }
            if (res == 1000001) {
                sb.append("Case ").append(idx++).append(": ").append(-1).append("\n");
            } else {
                sb.append("Case ").append(idx++).append(": ").append(res + 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
