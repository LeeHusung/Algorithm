import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m];
        int[][] ch = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                }
            }
        }
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] != 0) {
                        ch[nx][ny] = 1;
                        dist[nx][ny] = L;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == 0 && arr[i][j] == 1) {
                    dist[i][j] = -1;
                }
            }
        }

            StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
