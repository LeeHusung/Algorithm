import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, answer;
    static int[][] arr, ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 1;
        arr = new int[n][n];
        ch = new int[n][n];
        int max = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }


        for (int i = 1; i <= max; i++) {
            ch = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] <= i) {
                        ch[j][k] = 1;
                    }
                }
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (ch[j][k] == 0) {
                        cnt++;
                        q.offer(new int[]{j, k});
                        ch[j][k] = 1;
                        while (!q.isEmpty()) {
                            int[] p = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = p[0] + dx[l];
                                int ny = p[1] + dy[l];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
                                    q.offer(new int[]{nx, ny});
                                    ch[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
            }
            answer = Math.max(answer, cnt);

        }
        System.out.println(answer);

    }
}
