import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr, ch;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ch = new int[n][n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D(0, 0);
        System.out.println(min);

    }

    private static void D(int L, int val) {
        if (L == 3) {
            min = Math.min(min, val);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 < 0 || j - 1 < 0 || i + 1 >= n || j + 1 >= n) continue;
                if (ch[i][j] == 1 || ch[i][j - 1] == 1 || ch[i][j + 1] == 1 || ch[i - 1][j] == 1 || ch[i + 1][j] == 1) continue;
                ch[i][j] = 1;
                ch[i][j-1] = 1;
                ch[i][j+1] = 1;
                ch[i-1][j] = 1;
                ch[i+1][j] = 1;
                int sum = arr[i][j] + arr[i - 1][j] + arr[i + 1][j] + arr[i][j - 1] + arr[i][j + 1];
                D(L + 1, val += sum);
                ch[i][j] = 0;
                ch[i][j-1] = 0;
                ch[i][j+1] = 0;
                ch[i-1][j] = 0;
                ch[i+1][j] = 0;
                val -= sum;
            }
        }


    }
}
