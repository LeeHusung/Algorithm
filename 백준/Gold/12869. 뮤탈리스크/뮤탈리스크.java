import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[][][] dp;
    static int[] arr;
    static int[][] rota = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[3];
        answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[61][61][61];

        Queue<int[]> q = new ArrayDeque<>();
        if (n == 3) dp[arr[0]][arr[1]][arr[2]] = 1;
        if (n == 2) dp[arr[0]][arr[1]][0] = 1;
        if (n == 1) dp[arr[0]][0][0] = 1;

        q.offer(arr);
        boolean flag = false;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (p[0] <= 0 && p[1] <= 0 && p[2] <= 0) {
                    flag = true;
                    break;
                }
                for (int j = 0; j < 6; j++) {
                    int nx = p[0] - rota[j][0];
                    int ny = p[1] - rota[j][1];
                    int nz = p[2] - rota[j][2];
                    if (nx <= 0) nx = 0;
                    if (ny <= 0) ny = 0;
                    if (nz <= 0) nz = 0;
                    if (dp[nx][ny][nz] == 0) {
                        dp[nx][ny][nz] = dp[p[0]][p[1]][p[2]] + 1;
                        q.offer(new int[]{nx, ny, nz});
                    }
                }
            }
            if (flag) break;
        }
        System.out.println(dp[0][0][0] - 1);
    }
}
