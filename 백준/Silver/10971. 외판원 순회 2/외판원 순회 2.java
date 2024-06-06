import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max;
    static int[][] arr;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            ch[i] = 1;
            D(0, i, i, 0);
        }

        System.out.println(max);

    }

    private static void D(int L, int x, int now, int sum) {
        if (L == n - 1) {
            if (arr[x][now] > 0) {
                sum += arr[x][now];
                max = Math.min(max, sum);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0 && arr[x][i] > 0) {
                ch[i] = 1;
                D(L + 1, i, now, sum + arr[x][i]);
                ch[i] = 0;
            }
        }
    }
}
