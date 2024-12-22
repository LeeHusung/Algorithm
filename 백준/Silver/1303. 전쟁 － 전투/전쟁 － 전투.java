import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static char[][] arr;
    static int[][] ch;
    static int[] answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt = 0;
    private static void D(final int x, final int y, char color) {
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && ch[nx][ny] == 0 && arr[nx][ny] == color) {
                ch[nx][ny] = 1;
                D(nx, ny, arr[nx][ny]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new char[m][n];
        ch = new int[m][n];
        answer = new int[2];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt = 0;
                    D(i, j, arr[i][j]);
                    if (arr[i][j] == 'W') {
                        answer[0] += (cnt * cnt);
                    } else answer[1] += cnt * cnt;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
