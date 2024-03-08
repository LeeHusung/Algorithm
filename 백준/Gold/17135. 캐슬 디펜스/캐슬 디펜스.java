import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, d, answer, originalShooters, copyOS, res;
    static int[][] arr, ch, ch2, copy;
    static int[] shooters;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static Queue<int[]> q = new ArrayDeque<>();
    static Set<int[]> kill = new HashSet<>();
    public static void D(int L, int start) {
        if (L == 3) {
            while (true) {
                ch2 = new int[n][m];

                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (arr[i][j] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
                if (!flag) break;
                ch = new int[n][m];
                calculate();
                for (int[] x : kill) {
                    arr[x[0]][x[1]] = 0;
                    if (ch2[x[0]][x[1]] == 0) {
                        ch2[x[0]][x[1]] = 1;
                        res++;
                    }
                }

                down();

                kill.clear();
                q.clear();
            }
            answer = Math.max(answer, res);
            res = 0;
            copyOS = originalShooters;
            for (int i = 0; i < n; i++) {
                arr[i] = copy[i].clone();
            }
            return;
        }
        for (int i = start; i < m; i++) {
            shooters[i] = 1;
            D(L + 1, i + 1);
            shooters[i] = 0;
        }
    }


    private static void down() {
        for (int i = 0; i < m; i++) {
            arr[n - 1][i] = 0;
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    arr[i + 1][j] = 1;
                    arr[i][j] = 0;
                }
            }
        }

    }

    private static void calculate() {
        for (int i = 0; i < shooters.length; i++) {
            if (shooters[i] == 1) {
                q.offer(new int[]{n, i});
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    if (Math.abs(n - p[0]) + Math.abs(i - p[1]) > d) break;
                    if (p[0] >= 0 && p[1] >= 0 && p[0] < n && p[1] < m && arr[p[0]][p[1]] == 1 && Math.abs(n - p[0]) + Math.abs(i - p[1]) <= d) {
                        kill.add(new int[]{p[0], p[1]});
                        break;
                    }
                    for (int j = 0; j < 4; j++) {
                        int nx = p[0] + dx[j];
                        int ny = p[1] + dy[j];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m /* && ch[nx][ny] == 0*/) {
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
                q.clear();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);
        originalShooters = 0;
        arr = new int[n][m];
        copy = new int[n][m];
        ch = new int[n][m];
        ch2 = new int[n][m];
        shooters = new int[m];
        answer = 0;
        res = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) originalShooters++;
            }
        }
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i].clone();
        }
        copyOS = originalShooters;
        D(0, 0);
        System.out.println(answer);
    }
}