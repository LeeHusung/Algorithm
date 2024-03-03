import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x, y, k;
    static int[][] arr;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] zu = {0, 1, 2, 3, 4, 5, 6};
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        res = new int[7];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        String[] commands = br.readLine().split(" ");
        int nx = x, ny = y;
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(commands[i]);
            nx += dx[num];
            ny += dy[num];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                nx -= dx[num];
                ny -= dy[num];
                continue;
            }
            turn(num);
            if (arr[nx][ny] == 0) {
                arr[nx][ny] = res[zu[6]];
                sb.append(res[zu[1]]).append("\n");
            } else {
                res[zu[6]] = arr[nx][ny];
                arr[nx][ny] = 0;
                sb.append(res[zu[1]]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void turn(int num) {
        int x = 0, y = 0, z = 0, k = 0;
        switch (num) {
            case 1:
                x = zu[1];
                y = zu[3];
                z = zu[4];
                k = zu[6];
                zu[1] = z;
                zu[3] = x;
                zu[4] = k;
                zu[6] = y;
                break;
            case 2:
                x = zu[1];
                y = zu[3];
                z = zu[4];
                k = zu[6];
                zu[1] = y;
                zu[3] = k;
                zu[4] = x;
                zu[6] = z;
                break;
            case 3:
                x = zu[1];
                y = zu[2];
                z = zu[5];
                k = zu[6];
                zu[1] = z;
                zu[2] = x;
                zu[5] = k;
                zu[6] = y;
                break;
            case 4:
                x = zu[1];
                y = zu[2];
                z = zu[5];
                k = zu[6];
                zu[1] = y;
                zu[2] = k;
                zu[5] = x;
                zu[6] = z;
                break;
        }
    }

}