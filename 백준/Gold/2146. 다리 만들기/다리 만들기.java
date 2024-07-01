import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] arr = new int[n][n];
        int[][] ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && ch[i][j] == 0) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    arr[i][j] = idx;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && arr[nx][ny] == 1) {
                                arr[nx][ny] = idx;
                                ch[nx][ny] = 1;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    idx++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) {
                    ch = new int[n][n];
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    int L = 0;
                    boolean flag = false;
                    while (!q.isEmpty()) {
                        int len = q.size();
                        for (int k = 0; k < len; k++) {
                            int[] p = q.poll();
                            if (arr[p[0]][p[1]] != arr[i][j] && arr[p[0]][p[1]] != 0) {
                                flag = true;
                                min = Math.min(min, L);
                                q.clear();
                                break;
                            }
                            for (int l = 0; l < 4; l++) {
                                int nx = p[0] + dx[l];
                                int ny = p[1] + dy[l];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && arr[nx][ny] != arr[i][j]) {
                                    ch[nx][ny] = 1;
                                    q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                        if (flag) break;
                        L++;
                    }
                }
            }
        }
        System.out.println(min - 1);


    }
}
