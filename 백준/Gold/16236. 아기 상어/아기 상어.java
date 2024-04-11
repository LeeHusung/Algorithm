import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
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
        start = new int[2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        sharkSize = 2;
        int time = 0;
        int cnt = 0;

        while (true) {
            if (!canEat()) break;
            int[] next = pq.poll();
            time += next[2];
            arr[start[0]][start[1]] = 0;
            cnt++;
            if (sharkSize == cnt) {
                sharkSize++;
                cnt = 0;
            }
            start = next;
            pq.clear();
        }
        System.out.println(time);
    }

    private static boolean canEat() {
        boolean flag = false;
        int dist = 0;
        Queue<int[]> q = new ArrayDeque<>();
        ch = new int[n][n];
        q.offer(start);
        ch[start[0]][start[1]] = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            dist++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] <= sharkSize && ch[nx][ny] == 0) { //지나갈 수 있음
                        if (arr[nx][ny] > 0 && arr[nx][ny] < sharkSize) { //먹을 수 있음
                            pq.offer(new int[]{nx, ny, dist});
                            flag = true;
                        }
                        ch[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return flag;
    }
}
