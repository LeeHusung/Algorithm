import java.util.*;

public class Main {

    static int n, startX, startY, weight, eat;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 9) {
                    startX = i;
                    startY = j;
                    arr[i][j] = 0;
                }
            }
        }

        int result = 0;
        weight = 2;
        while (true) {

            int[] fish = bfs();
            if (fish == null) break;
            result += fish[2];
            startX = fish[0];
            startY = fish[1];
            arr[startX][startY] = 0;
            eat++;
            if (weight == eat) {
                weight++;
                eat = 0;
            }

        }
        System.out.println(result);
    }

    private static int[] bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        int[][] ch = new int[n][n];
        ch[startX][startY] = 1;
        pq.offer(new int[]{startX, startY, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], y = p[1], dist = p[2];
            if (arr[x][y] != 0 && arr[x][y] < weight) return new int[]{x, y, dist};
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && arr[nx][ny] <= weight) {
                    ch[nx][ny] = 1;
                    pq.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return null;
    }
}
