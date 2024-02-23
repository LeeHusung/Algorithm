import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, q, z, sum;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        q = Integer.parseInt(s[1]);
        sum = 0;
        z = 1;
        for (int i = 0; i < n; i++) {
            z *= 2;
        }
        arr = new int[z][z];
        for (int i = 0; i < z; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < z; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] levels = new int[q];
        for (int i = 0; i < q; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        for (int L : levels) {
            int k = 1;
            for (int i = 0; i < L; i++) {
                k *= 2;
            }
            for (int i = 0; i < z; i+=k) {
                for (int j = 0; j < z; j+=k) {
                    rotate(i, j, k);
                }
            }
            minus(arr);
        }

        int max = calculMaxArea(arr);

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < z; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
        System.out.println(max);

    }

    private static int calculMaxArea(int[][] arr) {
        int cnt = 0;
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] ch = new int[z][z];
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < z; j++) {
                if (ch[i][j] == 0 && arr[i][j] > 0) {
                    cnt = 0;
                    ch[i][j] = 1;
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        cnt++;
                        for (int k = 0; k < 4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < z && ny < z && arr[nx][ny] > 0 && ch[nx][ny] == 0) {
                                ch[nx][ny] = 1;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }

    private static void minus(int[][] arr) {
        List<int[]> minusList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int cnt = check(i, j);
                if (cnt <= 2) {
                    minusList.add(new int[]{i, j});
                }
            }
        }
        for (int[] x : minusList) {
            if (arr[x[0]][x[1]] > 0) {
                arr[x[0]][x[1]]--;
            }
        }
    }

    private static int check(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < z && ny < z && arr[nx][ny] > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void rotate(int x, int y, int k) {
        int[][] temp = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                temp[j][k - 1 - i] = arr[x + i][y + j];
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                arr[x + i][y + j] = temp[i][j];
            }
        }
    }
}
