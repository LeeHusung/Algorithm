import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, min, max;
    static String[][] arr;
    static int[][] ch;
    static String[] res;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void D(int L, int x, int y) {
        res[L] = arr[x][y];
        if (k-1 == L) {
            int one = Integer.parseInt(res[0]);
            for (int i = 1; i < res.length; i++) {
                if (res[i].equals("*")) {
                    one *= Integer.parseInt(res[i + 1]);
                    i++;
                } else if (res[i].equals("+")) {
                    one += Integer.parseInt(res[i + 1]);
                    i++;
                } else if (res[i].equals("-")) {
                    one -= Integer.parseInt(res[i + 1]);
                    i++;
                }
            }
            min = Math.min(one, min);
            max = Math.max(one, max);
            return;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                D(L + 1, nx, ny);
                ch[nx][ny] = 0;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        arr = new String[n][n];
        ch = new int[n][n];
        k = 0;
        if (n == 3) {
            k = 5;
        } else if (n == 5) {
            k = 9;
        }
        res = new String[k];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = s[j];
            }
        }
        ch[0][0] = 1;
        D(0, 0, 0);
        System.out.println(max + " " + min);
    }
}