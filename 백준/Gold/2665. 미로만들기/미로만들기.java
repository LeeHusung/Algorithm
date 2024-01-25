import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, answer;
    static int[][] arr, ch, dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ch = new int[n][n];
        dist = new int[n][n];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        q.offer(new int[]{0, 0});
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] > dist[p[0]][p[1]]) {
                    if (arr[nx][ny] == 0) dist[nx][ny] = dist[p[0]][p[1]] + 1;
                    else dist[nx][ny] = dist[p[0]][p[1]];
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.println(dist[n-1][n-1]);
    }


}
