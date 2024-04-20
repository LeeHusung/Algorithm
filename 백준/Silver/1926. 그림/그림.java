import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt, max, sum;
    static int[][] arr, ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        ch = new int[n][m];
        cnt = 1;
        sum = 0;
        max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 0 && arr[i][j] == 1) {
                    sum++;
                    ch[i][j] = 1;
                    D(i, j);
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println(sum);
        System.out.println(max);


    }

    private static void D(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == 1) {
                ch[nx][ny] = 1;
                cnt++;
                D(nx, ny);
            }
        }
    }
}
