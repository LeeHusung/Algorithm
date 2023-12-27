import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n, m, answer;
    static int[][] arr;
    static int[] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> q = new LinkedList<>();

    private static void D(int L, int x, int y) {
        if (ch[arr[x][y]] == 1) return;
        while (!q.isEmpty()) {
            int len = q.size();
            answer = Math.max(L, answer);
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();

                ch[arr[p[0]][p[1]]] = 1;
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[arr[nx][ny]] == 0) {
                        q.offer(new int[]{nx, ny});
                        D(L + 1, nx, ny);
                        ch[arr[nx][ny]] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        ch = new int[100];
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = split[j].charAt(0);
            }
        }
        q.offer(new int[]{0, 0});
        D(1, 0, 0);
        System.out.println(answer);


    }
}
