import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> q = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && ch[i][j] == 0) {
                    int cnt = 1;
                    idx++;
                    q.offer(new int[]{i, j});
                    ch[i][j] = idx;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1 && ch[nx][ny] == 0) {
                                ch[nx][ny] = idx;
                                q.offer(new int[]{nx, ny});
                                cnt++;
                            }
                        }
                    }
                    map.put(idx, cnt);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    int sum = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1) {
                            set.add(ch[nx][ny]);
                        }
                    }
                    for (Integer x : set) {
                        sum += map.get(x);
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        
        System.out.println(max);
    }
}
