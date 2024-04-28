import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, res;
    static int[] start, end;
    static int[][] arr;
    static int[][][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        dist = new int[n][m][2];
        start = new int[2];
        end = new int[2];
        res = 0;
        String[] s1 = br.readLine().split(" ");
        start[0] = Integer.parseInt(s1[0]) - 1;
        start[1] = Integer.parseInt(s1[1]) - 1;
        String[] s2 = br.readLine().split(" ");
        end[0] = Integer.parseInt(s2[0]) - 1;
        end[1] = Integer.parseInt(s2[1]) - 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dist[start[0]][start[1]][0] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.offer(new int[]{start[0], start[1], 0, 0});
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (p[0] == end[0] && p[1] == end[1]) {
                    System.out.println(p[2]);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (arr[nx][ny] == 0 && dist[nx][ny][p[3]] == 0) {
                            dist[nx][ny][p[3]] = 1;
                            q.offer(new int[]{nx, ny, p[2] + 1, p[3]});
                        } else if (arr[nx][ny] == 1 && p[3] == 0 && dist[nx][ny][1] == 0) {
                            dist[nx][ny][1] = 1;
                            q.offer(new int[]{nx, ny, p[2] + 1, 1});
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
