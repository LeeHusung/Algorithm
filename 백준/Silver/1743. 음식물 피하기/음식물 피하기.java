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
        int k = Integer.parseInt(s[2]);
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] arr = new int[n][m];
        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]) - 1;
            int y = Integer.parseInt(s1[1]) - 1;
            arr[x][y] = 1;
        }
        int[][] ch = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Queue<int[]> q = new LinkedList<>();

                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j, 1});
                    ch[i][j] = 1;
                }

                int L = 0;
                while (!q.isEmpty()) {
                    L++;
                    int[] p = q.poll();
                    for (int o = 0; o < 4; o++) {
                        int nx = p[0] + dx[o];
                        int ny = p[1] + dy[o];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1 && ch[nx][ny] == 0) {
                            ch[nx][ny] = 1;
                            q.offer(new int[]{nx, ny, p[2] + 1});
                        }
                    }
                    max = Math.max(max, L);
                }

            }
        }
        System.out.println(max);


    }
}
