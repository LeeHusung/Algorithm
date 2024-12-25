import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static long sum = 0;
    static int[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n / 2;
        int y = n / 2;

        ch = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int cnt = 1;
        int idx = 0;
        int k = 0;
        while (true) {
            for (int i = 0; i < 4; i++) {
                int[] p = ch[i];
                for (int j = 0; j < cnt; j++) {
                    int bx = x;
                    int by = y;
                    x += p[0];
                    y += p[1];
                    calculate(bx, by, x, y, i);
                    if (x == 0 && y == 0) {
                        System.out.println(sum);
                        return;
                    }
                }
                idx++;
                if (idx == 2) {
                    idx = 0;
                    cnt++;
                }
            }
        }
    }

    private static void calculate(final int bx, final int by, final int nx, final int ny, final int dir) {
        if (dir == 0) {
            long k = 0;
            int tmp = (int) (arr[nx][ny] * 0.01 * 5);
            if (ny - 2 < 0) {
                sum += tmp;
            } else {
                arr[nx][ny - 2] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 10);
            if (nx - 1 < 0 || ny - 1 < 0) {
                sum += tmp;
            } else {
                arr[nx - 1][ny - 1] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n || ny - 1 < 0) {
                sum += tmp;
            } else {
                arr[nx + 1][ny - 1] += tmp;
            }

            k += tmp;

            tmp = (int) (arr[nx][ny] * 0.01 * 7);
            if (nx - 1 < 0) {
                sum += tmp;
            } else {
                arr[nx - 1][ny] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n) {
                sum += tmp;
            } else  {
                arr[nx + 1][ny] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 2);
            if (nx - 2 < 0) {
                sum += tmp;
            } else  {
                arr[nx - 2][ny] += tmp;
            }
            k += tmp;

            if (nx + 2 >= n) {
                sum += tmp;
            } else  {
                arr[nx + 2][ny] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 1);
            if (nx - 1 < 0 || ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx - 1][ny + 1] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n || ny + 1 >= n) {
                sum += tmp;
            } else  {
                arr[nx + 1][ny + 1] += tmp;
            }
            k += tmp;


            if (ny - 1 < 0) {
                sum += arr[nx][ny] - k;
            } else arr[nx][ny - 1] += arr[nx][ny] - k;
            arr[nx][ny] = 0;
        }
        else if (dir == 1) {
            long k = 0;
            int tmp = (int) (arr[nx][ny] * 0.01 * 5);
            if (nx + 2 >= n) {
                sum += tmp;
            } else {
                arr[nx + 2][ny] += tmp;
            }
            k += tmp;

            tmp = (int) (arr[nx][ny] * 0.01 * 10);
            if (nx + 1 >= n || ny - 1 < 0) {
                sum += tmp;
            } else {
                arr[nx + 1][ny - 1] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n || ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx + 1][ny + 1] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 7);
            if (ny - 1 < 0) {
                sum += tmp;
            } else  {
                arr[nx][ny - 1] += tmp;
            }
            k += tmp;

            if (ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx][ny + 1] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 2);
            if (ny - 2 < 0) {
                sum += tmp;
            } else {
                arr[nx][ny - 2] += tmp;
            }
            k += tmp;

            if (ny + 2 >= n) {
                sum += tmp;
            } else {
                arr[nx][ny + 2] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 1);
            if (nx - 1 < 0 || ny - 1 < 0) {
                sum += tmp;
            } else  {
                arr[nx - 1][ny - 1] += tmp;
            }
            k += tmp;

            if (nx - 1 < 0 || ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx - 1][ny + 1] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n) {
                sum += arr[nx][ny] - k;
            } else arr[nx + 1][ny] += arr[nx][ny] - k;
            arr[nx][ny] = 0;
        }
        else if (dir == 2) {
            long k = 0;
            int tmp = (int) (arr[nx][ny] * 0.01 * 5);
            if (ny + 2 >= n) {
                sum += tmp;
            } else {
                arr[nx][ny + 2] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 10);
            if (nx - 1 < 0 || ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx - 1][ny + 1] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n || ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx + 1][ny + 1] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 7);
            if (nx - 1 < 0) {
                sum += tmp;
            } else {
                arr[nx - 1][ny] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx + 1][ny] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 2);
            if (nx - 2 < 0) {
                sum += tmp;
            } else {
                arr[nx - 2][ny] += tmp;
            }
            k += tmp;

            if (nx + 2 >= n) {
                sum += tmp;
            } else  {
                arr[nx + 2][ny] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 1);
            if (nx - 1 < 0 || ny - 1 < 0) {
                sum += tmp;
            } else  {
                arr[nx - 1][ny - 1] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n || ny - 1 < 0) {
                sum += tmp;
            } else  {
                arr[nx + 1][ny - 1] += tmp;
            }
            k += tmp;

            if (ny + 1 >= n) {
                sum += arr[nx][ny] - k;
            } else arr[nx][ny + 1] += arr[nx][ny] - k;
            arr[nx][ny] = 0;
        }
        else if (dir == 3) {
            long k = 0;
            int tmp = (int) (arr[nx][ny] * 0.01 * 5);
            if (nx - 2 < 0) {
                sum += tmp;
            } else {
                arr[nx - 2][ny] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 10);
            if (nx - 1 < 0 || ny - 1 < 0) {
                sum += tmp;
            } else {
                arr[nx - 1][ny - 1] += tmp;
            }
            k += tmp;

            if (nx - 1 < 0 || ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx - 1][ny + 1] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 7);
            if (ny - 1 < 0) {
                sum += tmp;
            } else  {
                arr[nx][ny - 1] += tmp;
            }
            k += tmp;

            if (ny + 1 >= n) {
                sum += tmp;
            } else  {
                arr[nx][ny + 1] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 2);
            if (ny - 2 < 0) {
                sum += tmp;
            } else {
                arr[nx][ny - 2] += tmp;
            }
            k += tmp;

            if (ny + 2 >= n) {
                sum += tmp;
            } else {
                arr[nx][ny + 2] += tmp;
            }
            k += tmp;


            tmp = (int) (arr[nx][ny] * 0.01 * 1);
            if (nx + 1 >= n || ny - 1 < 0) {
                sum += tmp;
            } else  {
                arr[nx + 1][ny - 1] += tmp;
            }
            k += tmp;

            if (nx + 1 >= n || ny + 1 >= n) {
                sum += tmp;
            } else {
                arr[nx + 1][ny + 1] += tmp;
            }
            k += tmp;

            if (nx - 1 < 0) {
                sum += arr[nx][ny] - k;
            } else arr[nx - 1][ny] += arr[nx][ny] - k;
            arr[nx][ny] = 0;
        }
    }

}
