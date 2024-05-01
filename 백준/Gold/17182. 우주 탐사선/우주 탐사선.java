
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, min;
    static int[][] arr, dist, check;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        arr = new int[n][n];
        dist = new int[n][n];
        check = new int[n][n];
        ch = new int[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    dist[j][l] = Math.min(dist[j][l], arr[j][i] + arr[i][l]);
                }
            }
        }
      
        ch[k] = 1;
        //back-tracking
        D(k, 0, 1);
        System.out.println(min);

    }

    private static void D(int idx, int sum, int cnt) {
        if (cnt == n) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                D(i, sum + dist[idx][i], cnt + 1);
                ch[i] = 0;
            }
        }
    }
}
