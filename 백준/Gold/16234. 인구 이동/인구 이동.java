import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, L, R;
    static int[][] arr, ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);

        arr = new int[N][N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        while (true) {
            int get = getMoveDay();
            if (get > 0) answer++;
            else break;
        }
        System.out.println(answer);
    }

    private static int getMoveDay() {
        int level = 0;
        ch = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ch[i][j] == 1) continue;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                ch[i][j] = 1;
                LinkedList<int[]> list = new LinkedList<>();
                int sum = 0;
                int cnt = 0;
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    sum += arr[p[0]][p[1]];
                    list.add(new int[]{p[0], p[1]});
                    cnt++;
                    for (int k = 0; k < 4; k++) {
                        int nx = p[0] + dx[k];
                        int ny = p[1] + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N && ch[nx][ny] == 0
                                && Math.abs(arr[nx][ny] - arr[p[0]][p[1]]) >= L
                                && Math.abs(arr[nx][ny] - arr[p[0]][p[1]]) <= R) {
                            ch[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                            level++;
                        }
                    }
                }
//                System.out.println(sum);
//                System.out.println(cnt);
                for (int[] x : list) {
                    arr[x[0]][x[1]] = sum / cnt;
                }

            }
        }
        return level;
    }
}
