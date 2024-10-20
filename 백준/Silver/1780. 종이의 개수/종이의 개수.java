import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int zero, plus, minus;
    private static void divide(int n, int x, int y) {
        if (sameNum(n, x, y)) {
            int tmp = arr[x][y];
            if (tmp == 0) zero++;
            else if (tmp == 1) plus++;
            else if (tmp == -1) minus++;
        } else {
            int resize = n / 3;
            int[] xarr = {x, x, x, x + resize, x + resize, x + resize, x + (resize * 2), x + (resize * 2), x + (resize * 2)};
            int[] yarr = {y, y + resize, y + (resize * 2), y, y + resize, y + (resize * 2), y, y + resize, y + (resize * 2)};
            for (int i = 0; i < 9; i++) {
                divide(resize, xarr[i], yarr[i]);
            }
        }

    }

    private static boolean sameNum(int n, int x, int y) {
        if (n == 1) return true;
        else {
            int k = arr[x][y];
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    if (arr[i][j] != k) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        zero = 0;
        plus = 0;
        minus = 0;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(n, 0, 0);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

}
