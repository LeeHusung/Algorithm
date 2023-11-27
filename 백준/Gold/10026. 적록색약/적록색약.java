import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, cnt;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] ch;
    static int[][] arr;

    public static void D(int x, int y, int k) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && arr[nx][ny] == k) {
                ch[nx][ny] = 1;
                D(nx, ny, k);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = 0;
        arr = new int[n][n];
        ch = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (String.valueOf(s.charAt(j)).equals("R")) arr[i][j] = 1;
                if (String.valueOf(s.charAt(j)).equals("G")) arr[i][j] = 2;
                if (String.valueOf(s.charAt(j)).equals("B")) arr[i][j] = 3;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt++;
                    D(i, j, 1);
                }if (arr[i][j] == 2 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt++;
                    D(i, j, 2);
                }if (arr[i][j] == 3 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt++;
                    D(i, j, 3);
                }
            }
        }
        System.out.print(cnt + " ");
        cnt = 0;
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) arr[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt++;
                    D(i, j, 1);
                }
                if (arr[i][j] == 3 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt++;
                    D(i, j, 3);
                }
            }
        }
        System.out.println(cnt);

    }
}
