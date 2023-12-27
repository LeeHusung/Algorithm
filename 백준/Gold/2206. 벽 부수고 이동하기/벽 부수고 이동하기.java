import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        ch = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        LinkedList<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 0});
        ch[0][0][0] = 1;

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
//                if (p[2] > 1) continue;
//                System.out.println("p[0] p[1] = " + p[0] + " " + p[1] + " ");
                if (p[0] == n-1 && p[1] == m-1) return L;
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && p[2] == 0 && ch[nx][ny][p[2] + 1] == 0 && arr[nx][ny] == 1) {
                        ch[nx][ny][p[2] + 1] = 1;
                        q.offer(new int[]{nx, ny, p[2] + 1});
                    }
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny][p[2]] == 0 && arr[nx][ny] == 0) {
                        ch[nx][ny][p[2]] = 1;
                        q.offer(new int[]{nx, ny, p[2]});
                    }
                }
            }
        }
        return -1;
    }
}
