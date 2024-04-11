import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, sharkSize;
    static int[] start;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr, ch;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ch = new int[n][n];
        start = new int[3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    start[0] = i;
                    start[1] = j;
                    arr[i][j] = 0;
                }
            }
        }
        sharkSize = 2;
        int time = 0;
        int cnt = 0;

        while (true) {
            int[] next = canEat();
            if (next == null) break;
            time += next[2];
            cnt++;
            start[0] = next[0];
            start[1] = next[1];
            arr[next[0]][next[1]] = 0;
            if (sharkSize == cnt) {
                sharkSize++;
                cnt = 0;
            }
            pq.clear();
        }
        System.out.println(time);
    }

    private static int[] canEat() {
        pq.offer(new int[]{start[0], start[1], 0});
        ch = new int[n][n];
        ch[start[0]][start[1]] = 1;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (arr[p[0]][p[1]] > 0 && arr[p[0]][p[1]] < sharkSize) return p;
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] <= sharkSize && ch[nx][ny] == 0) { //지나갈 수 있음
                    pq.offer(new int[]{nx, ny, p[2] + 1});
                    ch[nx][ny] = 1;
                }
            }
        }
        return null;
    }
}
