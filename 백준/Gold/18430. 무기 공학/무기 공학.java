import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer;
    static int[][] arr, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        ch = new int[n][m];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D(0, 0);
        System.out.println(answer);
    }

    private static void D(int L, int sum) {
        if (L == n * m) {
            answer = Math.max(answer, sum);
            return;
        }
        int x = L / m;
        int y = L % m;

        if (ch[x][y] == 0) {
            if (y + 1 < m && x + 1 < n && ch[x][y + 1] == 0 && ch[x + 1][y] == 0) {
                ch[x][y] = 1;
                ch[x][y + 1] = 1;
                ch[x + 1][y] = 1;
                int tSum = sum + 2 * arr[x][y] + arr[x][y + 1] + arr[x + 1][y];
                D(L + 1, tSum);
                ch[x][y] = 0;
                ch[x][y + 1] = 0;
                ch[x + 1][y] = 0;
            }
            if (y + 1 < m && x - 1 >= 0 && ch[x][y + 1] == 0 && ch[x - 1][y] == 0) {
                ch[x][y] = 1;
                ch[x][y + 1] = 1;
                ch[x - 1][y] = 1;
                int tSum = sum + 2 * arr[x][y] + arr[x][y + 1] + arr[x - 1][y];
                D(L + 1, tSum);
                ch[x][y] = 0;
                ch[x][y + 1] = 0;
                ch[x - 1][y] = 0;
            }
            if (y - 1 >= 0 && x - 1 >= 0 && ch[x][y - 1] == 0 && ch[x - 1][y] == 0) {
                ch[x][y] = 1;
                ch[x][y - 1] = 1;
                ch[x - 1][y] = 1;
                int tSum = sum + 2 * arr[x][y] + arr[x][y - 1] + arr[x - 1][y];
                D(L + 1, tSum);
                ch[x][y] = 0;
                ch[x][y - 1] = 0;
                ch[x - 1][y] = 0;
            }
            if (y - 1 >= 0 && x + 1 < n && ch[x][y - 1] == 0 && ch[x + 1][y] == 0) {
                ch[x][y] = 1;
                ch[x][y - 1] = 1;
                ch[x + 1][y] = 1;
                int tSum = sum + 2 * arr[x][y] + arr[x][y - 1] + arr[x + 1][y];
                D(L + 1, tSum);
                ch[x][y] = 0;
                ch[x][y - 1] = 0;
                ch[x + 1][y] = 0;
            }
        }
        D(L + 1, sum);

    }


}
