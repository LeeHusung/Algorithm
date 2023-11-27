import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int n, cnt;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] ch;
    static int[][] arr;

    public static int D(int x, int y) {
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && arr[nx][ny] == 1) {
                ch[nx][ny] = 1;
                D(nx, ny);
            }
        }
        return cnt;
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
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt = 0;
                    int r = D(i, j);
                    res.add(r);
                }
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        for (int x : res) {
            System.out.println(x);
        }

    }
}
