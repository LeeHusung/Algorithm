import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        char[][] arr = new char[n][m];
        int[][] ch = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int L = 0;
        while (true) {
            ch = new int[n][m];
            q.offer(new int[]{x1, y1});
            ch[x1][y1] = 1;
            L++;
            while (!q.isEmpty()) {
                int[] p = q.poll();
                if (p[0] == x2 && p[1] == y2) {
                    System.out.println(L);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || ch[nx][ny] == 1) {
                        continue;
                    }
                    if (arr[nx][ny] == '0' || arr[nx][ny] == '#') {
                        q.offer(new int[]{nx, ny});
                        ch[nx][ny] = 1;
                    } else if (arr[nx][ny] == '1') {
                        arr[nx][ny] = '0';
                        ch[nx][ny] = 1;
                    }
                }
            }
        }
    }
}
