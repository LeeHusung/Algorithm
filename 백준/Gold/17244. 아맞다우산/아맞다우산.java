import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int n, m, cnt;
    static int[][] arr, cost;
    static int[] tmp, ch;
    static Map<Integer, int[]> map = new HashMap<>();
    static int min = Integer.MAX_VALUE;
    static int[] s, e;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        arr = new int[m][n];
        s = new int[2];
        e = new int[2];
        cnt = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '#') {
                    arr[i][j] = -1;
                } else if (str.charAt(j) == 'X') {
                    arr[i][j] = 1;
                    cnt++;
                    map.put(cnt, new int[]{i, j});
                } else if (str.charAt(j) == 'S') {
                    s[0] = i;
                    s[1] = j;
                } else if (str.charAt(j) == 'E') {
                    e[0] = i;
                    e[1] = j;
                }
            }
        }
        tmp = new int[cnt];
        ch = new int[cnt];
        map.put(0, s);
        map.put(cnt + 1, e);
        cost = new int[cnt + 2][cnt + 2];

        calculateDistance();
//        for (int i = 0; i < cost.length; i++) {
//            for (int j = 0; j < cost[i].length; j++) {
//                System.out.print(cost[i][j] + " ");
//            }
//            System.out.println();
//        }
        D(0);
        System.out.println(min);

    }

    private static void calculateDistance() {
        for (int i = 0; i <= cnt + 1; i++) {
            int[] x = map.get(i);
            Queue<int[]> q = new ArrayDeque<>();
            for (int j = i + 1; j <= cnt + 1; j++) {
                int[] y = map.get(j);
                int L = 0;
                q.offer(x);
                int[][] visited = new int[m + 1][n + 1];
                visited[x[0]][x[1]] = 1;
                while (!q.isEmpty()) {
                    boolean flag = false;
                    L++;
                    int len = q.size();
                    for (int z = 0; z < len; z++) {
                        int[] p = q.poll();
                        if (p[0] == y[0] && p[1] == y[1]) {
                            cost[i][j] = L - 1;
                            cost[j][i] = L - 1;
                            flag = true;
                            q.clear();
                            break;
                        }
                        for (int k = 0; k < 4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if (nx < 0 || ny < 0 || nx >= m || ny >= n || arr[nx][ny] == -1) continue;
                            if (visited[nx][ny] == 1) continue;
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = 1;
                        }
                    }
                    if (flag) break;
                }
            }
        }

    }

    private static void D(int L) {
        if (L == cnt) {
            min = Math.min(min, check());
            return;
        }

        for (int i = 0; i < cnt; i++) {
            if (ch[i] == 1) continue;
            tmp[L] = i + 1;
            ch[i] = 1;
            D(L + 1);
            ch[i] = 0;
        }
    }

    private static int check() {
        int sum = 0;
        int start = 0;
        for (int x : tmp) {
            sum += cost[start][x];
            start = x;
        }
        sum += cost[start][cnt + 1];
        return sum;

    }
}
