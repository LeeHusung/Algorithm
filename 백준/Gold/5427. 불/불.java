import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w, h, startX, startY;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Character[][] arr;
    static int[][] ch, fire;
    static Queue<int[]> q = new ArrayDeque<>();
    static Queue<int[]> fires = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new Character[h][w];
            ch = new int[h][w];
            fire = new int[h][w];
            startX = 0;
            startY = 0;
            q.clear();
            fires.clear();
            for (int i = 0; i < h; i++) {
                Arrays.fill(fire[i], Integer.MAX_VALUE);
                Arrays.fill(ch[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == '@') {
                        startX = i;
                        startY = j;
                        arr[i][j] = '.';
                    }
                    if (arr[i][j] == '*') {
                        fire[i][j] = 0;
                        fires.add(new int[]{i, j});
                    }
                }
            }
            spread();

            int L = bfs();
            if (L == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
            else System.out.println(L);

        }

    }

    private static void spread() {
        while (!fires.isEmpty()) {
            int[] p = fires.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] != '#' && fire[nx][ny] == Integer.MAX_VALUE) {
                    fire[nx][ny] = fire[p[0]][p[1]] + 1;
                    fires.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static int bfs() {
        q.offer(new int[]{startX, startY});
        ch[startX][startY] = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (p[0] == 0 || p[1] == 0 || p[0] == h - 1 || p[1] == w - 1) return ch[p[0]][p[1]] + 1;
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == '.' && ch[nx][ny] == Integer.MAX_VALUE && ch[p[0]][p[1]] + 1 < fire[nx][ny]) {
                        ch[nx][ny] = ch[p[0]][p[1]] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}