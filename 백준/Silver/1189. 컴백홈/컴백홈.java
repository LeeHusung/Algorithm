import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int r, c, k, res;
    static char[][] arr;
    static int[][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    private static void D(int x, int y, int cnt) {
        if (x == 0 && y == c - 1) {
            if (cnt == k) {
                res++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c && ch[nx][ny] == 0 && arr[nx][ny] != 'T') {
                ch[nx][ny] = 1;
                D(nx, ny, cnt+=1);
                cnt-=1;
                ch[nx][ny] = 0;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        res = 0;
        arr = new char[r][c];
        ch = new int[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        ch[r - 1][0] = 1;
        D(r - 1, 0, 1);
        System.out.println(res);

    }
}
