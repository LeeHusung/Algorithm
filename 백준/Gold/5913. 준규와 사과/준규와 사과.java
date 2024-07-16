import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int k, move;
    static int[][] arr, ch;
    static int cnt;
    private static void D(int L, int x, int y) {
        if (x == 4 && y == 4 && L == move) {
            cnt++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx > 4 || ny > 4 || ch[nx][ny] == 1 || arr[nx][ny] == 1) continue;
            ch[nx][ny] = 1;
            D(L + 1, nx, ny);
            ch[nx][ny] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[5][5];
        ch = new int[5][5];
        cnt = 0;
        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]) - 1;
            int y = Integer.parseInt(s[1]) - 1;
            arr[x][y] = 1;
        }

        move = (25 - k);

        ch[0][0] = 1;
        D(1, 0, 0);
        System.out.println(cnt);

    }
}
