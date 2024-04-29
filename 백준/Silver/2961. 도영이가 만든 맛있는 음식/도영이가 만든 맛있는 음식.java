import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, answer, c;
    static int[][] arr;
    static int[] cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        cur = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        answer = Integer.MAX_VALUE;
        c = 0;
        D(0, 1);
        System.out.println(answer);
    }

    private static void D(int L, int start) {
        if (L > 0) {
            int sin = 1;
            int bit = 0;
            for (int i = 0; i < cur.length; i++) {
                if (cur[i] > 0) {
                    sin *= arr[cur[i] - 1][0];
                    bit += arr[cur[i] - 1][1];
                }
            }
            answer = Math.min(answer, Math.abs(sin - bit));
        }
        for (int i = start; i <= n; i++) {
            cur[L] = i;
            D(L + 1, i + 1);
            cur[L] = 0;
        }
    }
}
