import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int[][] arr = new int[n][n];
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            q.offer(new int[]{0, 0, arr[0][0]});

            while (!q.isEmpty()) {
                int[] p = q.poll();
                if (p[2] > dist[p[0]][p[1]]) continue;
                for (int i = 0; i < 4; i++) {
                    int nx = p[0] + dx[i];
                    int ny = p[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (dist[nx][ny] > p[2] + arr[nx][ny]) {
                            dist[nx][ny] = p[2] + arr[nx][ny];
                            q.offer(new int[]{nx, ny, dist[nx][ny]});
                        }
                    }
                }
            }

            sb.append("Problem " + idx++ + ": " + dist[n-1][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}
