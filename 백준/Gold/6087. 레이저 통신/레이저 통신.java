import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] start;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[0]);
        arr = new int[n][m];
        start = new int[2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char x = str.charAt(j);
                if (x == '.') arr[i][j] = -1;
                else if (x == '*') arr[i][j] = -2;
                else if (x == 'C') {
                    start[0] = i;
                    start[1] = j;
                    arr[i][j] = -3;
                }
            }
        }
        arr[start[0]][start[1]] = 0;
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0];
                int ny = p[1];
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
                    if (arr[nx][ny] == -3) {
                        answer = p[2];
                        pq.clear();
                        break;
                    } else if (arr[nx][ny] == -2) {
                        break;
                    } else if (arr[nx][ny] == -1) {
                        arr[nx][ny] = p[2];
                        pq.offer(new int[]{nx, ny, p[2] + 1});
                    } else if (arr[nx][ny] >= 0 && arr[nx][ny] != p[2]) break;
                }
            }
        }

        System.out.println(answer);
    }
}
