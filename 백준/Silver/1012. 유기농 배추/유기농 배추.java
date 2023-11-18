import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int cnt = 0;
        while (true) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] arr = new int[m][n];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }

            Queue<int[]> q = new LinkedList<>();
            int L = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        L++;
                    }
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = p[0] + dx[l];
                            int ny = p[1] + dy[l];
                            if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[nx][ny] == 1) {
                                arr[nx][ny] = 2;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            System.out.println(L);

            cnt++;
            if (cnt == t) break;
        }

    }
}
