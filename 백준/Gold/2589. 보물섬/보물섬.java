import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr, dist, ch;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < m; j++) {
                if (x.charAt(j) == 'W') arr[i][j] = 1;
                else arr[i][j] = 0;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    ch = new int[n][m];
                    ch[i][j] = 1;
                    q.offer(new int[]{i, j});
                    int L = 0;
                    while (!q.isEmpty()) {
                        L++;
                        int len = q.size();
                        for (int k = 0; k < len; k++) {
                            int[] p = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = p[0] + dx[l];
                                int ny = p[1] + dy[l];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == 0) {
                                    ch[nx][ny] = 1;
                                    q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    answer = Math.max(answer, L);
                }
            }
        }
        System.out.println(answer - 1);
    }
}
