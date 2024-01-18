import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][m];
        int[][] ch = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        System.out.println(bfs(n, m, arr, ch, dx, dy));

    }

    private static int bfs(int n, int m, int[][] arr, int[][] ch, int[] dx, int[] dy) {
        Queue<int[]> q = new LinkedList<>();
        int L = 0;
        q.offer(new int[]{0, 0});
        ch[0][0] = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (p[0] == n - 1 && p[1] == m - 1) return L;
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == 1) {
                        ch[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }

        }
        return 0;
    }
}
