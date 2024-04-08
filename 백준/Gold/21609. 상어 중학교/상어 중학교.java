import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr, ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][n];
        ch = new int[n][n];
        StringTokenizer st;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (b[1] == a[1] ? (b[2] == a[2] ? b[3] - a[3] : b[2] - a[2]) : b[1] - a[1]) : b[0] - a[0]);

        while (true) {
            Queue<int[]> q = new ArrayDeque<>();
            List<int[]> list = new ArrayList<>();
            ch = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int rainbow = 0;
                    int cnt = 0;
                    if (arr[i][j] > 0 && ch[i][j] == 0) {
                        q.offer(new int[]{i, j});
                        ch[i][j] = 1;
                        cnt++;
                        while (!q.isEmpty()) {
                            int[] p = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = p[0] + dx[k];
                                int ny = p[1] + dy[k];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
                                    if (arr[nx][ny] == arr[i][j] || arr[nx][ny] == 0) {
                                        if (arr[nx][ny] == 0) {
                                            rainbow++;
                                            list.add(new int[]{nx, ny});
                                        }
                                        q.offer(new int[]{nx, ny});
                                        ch[nx][ny] = 1;
                                        cnt++;
                                    }
                                }
                            }
                        }
                        if (cnt >= 2) {
                            pq.offer(new int[]{cnt, rainbow, i, j});
                        }
                        for (int[] x : list) {
                            ch[x[0]][x[1]] = 0;
                        }
                    }
                }
            }

            if (pq.isEmpty()) {
                System.out.println(answer);
                break;
            }
            if (!pq.isEmpty()) {
                ch = new int[n][n];
                q = new ArrayDeque<>();
                answer += (long) pq.peek()[0] * pq.peek()[0];
                int startX = pq.peek()[2];
                int startY = pq.peek()[3];

                ch[startX][startY] = 1;
                q.offer(new int[]{startX, startY});
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = p[0] + dx[k];
                        int ny = p[1] + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
                            if (arr[nx][ny] == arr[startX][startY] || arr[nx][ny] == 0) {
                                arr[nx][ny] = -5;
                                q.offer(new int[]{nx, ny});
                                ch[nx][ny] = 1;
                            }
                        }
                    }
                }
                arr[startX][startY] = -5;
            }

            down();
            rotate();
            down();
            pq.clear();
        }
    }

    private static void rotate() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (int j = n-1; j >= 0; j--) {
                copy[idx++][i] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) arr[i] = copy[i].clone();
    }

    private static void down() {
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -5) {
                    for (int k = i-1; k >= 0; k--) {
                        if (arr[k][j] == -1) {
                            break;
                        }
                        if (arr[k][j] >= 0) {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = -5;
                            break;
                        }
                    }
                }
            }
        }
    }

}
