import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();;
            for (int j = 0; j < m; j++) {
                if (s1.charAt(j) == '1') arr[i][j] = 1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> q = new ArrayDeque<>();
        int[][] ch = new int[n][m];
        StringBuilder sb = new StringBuilder();
        int[][] dist = new int[n][m];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 || ch[i][j] == 1) continue;
                int cnt = 0;
                if (arr[i][j] == 0 && ch[i][j] == 0) {
                    idx++;
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    dist[i][j] = idx;
                    cnt++;
                }
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = p[0] + dx[k];
                        int ny = p[1] + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m || ch[nx][ny] == 1 || arr[nx][ny] == 1) continue;
                        ch[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] = idx;
                        cnt++;
                    }
                }
                map.put(idx, cnt);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Set<Integer> set = new HashSet<>();
                if (dist[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m || dist[nx][ny] == 0 || arr[nx][ny] > 0) continue;
                        set.add(dist[nx][ny]);
                    }
                }
                for (int x : set) {
                    arr[i][j] += map.get(x);
                }
                set.clear();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j] % 10);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
