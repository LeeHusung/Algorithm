import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<int[]>[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] star;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new ArrayList[n][n];
        star = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y].add(new int[]{a, b});
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        star[0][0] = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            // 현재 방에서 불을 켤 수 있는 방들의 불을 켬
            for (int[] next : arr[p[0]][p[1]]) {
                if (star[next[0]][next[1]] == 0) {  // 아직 불이 꺼져 있는 방
                    star[next[0]][next[1]] = 1;
                }
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                // 범위 내에 있고, 불이 켜져 있으며, 방문하지 않은 방만 탐색
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && star[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

            // 다시 탐색하기 위해 모든 방을 재확인
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (star[i][j] == 1 && !visited[i][j]) {
                        // 불이 켜져 있지만 방문하지 않은 방을 다시 큐에 넣음
                        for (int k = 0; k < 4; k++) {
                            int ni = i + dx[k];
                            int nj = j + dy[k];
                            if (ni >= 0 && nj >= 0 && ni < n && nj < n && visited[ni][nj]) {
                                visited[i][j] = true;
                                q.offer(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (star[i][j] == 1) res++;
            }
        }
        System.out.println(res);
    }
}
