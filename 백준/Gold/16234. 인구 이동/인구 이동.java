import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N, L, R;
    static int[][] arr, ch;
    static Queue<int[]> q = new LinkedList<>();
    static List<int[]> list = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    private static void move(int x, int y) {
        int sum = arr[x][y];
        int size = 1;
        list.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int j = 0; j < 4; j++) {
                int nx = p[0] + dx[j];
                int ny = p[1] + dy[j];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && ch[nx][ny] == 0 && checkInRange(p, nx, ny)) {
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                    size++;
                    sum += arr[nx][ny];
                }
            }
        }
        for (int[] z : list) {
            arr[z[0]][z[1]] = sum / size;
        }
    }

    private static boolean checkInRange(int[] p, int nx, int ny) {
        int chai = Math.abs(arr[p[0]][p[1]] - arr[nx][ny]);
        if (chai >= L && chai <= R) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);

        arr = new int[N][N];
        ch = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        int time = 0;
        while (true) {
            int cnt = 0;
            ch = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check(i, j) && ch[i][j] == 0) {
                        cnt++;
                        q.offer(new int[]{i, j});
                        ch[i][j] = 1;
                        move(i, j);
                        list.clear();
                        q.clear();
                    }
                }
            }
            if (cnt == 0) break;
            time++;
        }
        System.out.println(time);
    }

    private static boolean check(int x, int y) {
        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && Math.abs(arr[nx][ny] - arr[x][y]) >= L && Math.abs(arr[nx][ny] - arr[x][y]) <= R) {
                return true;
            }
        }
        return false;
    }

}
