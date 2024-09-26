import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int t = Integer.parseInt(s[2]);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        int[][] arr = new int[n][m];
        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        ch[0][0] = 1;
        int L = 0;
        int res = 50000;
        while (!q.isEmpty()) {
            L++;
            if (L - 1 > t) break;

            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (p[0] == n - 1 && p[1] == m - 1 && t >= L - 1) {
                    res = Math.min(res, L - 1);
                }
                for (int k = 0; k < 4; k++) {
                    int nx = p[0] + dx[k];
                    int ny = p[1] + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || ch[nx][ny] > 0 || arr[nx][ny] == 1) continue;

                    ch[nx][ny] = L;
                    q.offer(new int[]{nx, ny});

                }
            }
        }
        L = 0;
        q = new ArrayDeque<>();
        ch = new int[n][m];
        q.offer(new int[]{0, 0});
        ch[0][0] = 1;
        while (!q.isEmpty()) {
            L++;
            if (L - 1 > t) break;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (arr[p[0]][p[1]] == 2) {
                    int k = n - 1 - p[0];
                    int k2 = m - 1 - p[1];
                    if (L - 1 + k + k2 <= t) {
                        res = Math.min(res, L - 1 + k + k2);
                    }
//                    makeNoWall(n, m, arr);
                }
                if (p[0] == n - 1 && p[1] == m - 1 && t >= L - 1) {
                    res = Math.min(res, L - 1);
                }
                for (int k = 0; k < 4; k++) {
                    int nx = p[0] + dx[k];
                    int ny = p[1] + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || ch[nx][ny] > 0 || arr[nx][ny] == 1) continue;

                    ch[nx][ny] = L;
                    q.offer(new int[]{nx, ny});

                }
            }
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(ch[i][j] + " ");
//            }
//            System.out.println();
//        }
        if (res == 50000) {
            System.out.println("Fail");
        } else System.out.println(res);


    }

    private static void makeNoWall(int n, int m, int[][] arr) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (arr[j][k] == 1) {
                    arr[j][k] = 0;
                }
            }
        }
    }
}
