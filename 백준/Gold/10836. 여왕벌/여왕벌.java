import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[][] arr = new int[m][m];
        int[] cnt = new int[2 * m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int zeroCnt = Integer.parseInt(st.nextToken());
            int oneCnt = Integer.parseInt(st.nextToken());
            int twoCnt = Integer.parseInt(st.nextToken());
            int idx = 0;
            for (int j = 0; j < zeroCnt; j++) {
                cnt[idx++] += 0;
            }
            for (int j = 0; j < oneCnt; j++) {
                cnt[idx++] += 1;
            }
            for (int j = 0; j < twoCnt; j++) {
                cnt[idx++] += 2;
            }
        }

        int idx = 0;
        for (int i = m - 1; i >= 0; i--) {
            arr[i][0] += cnt[idx++];
        }
        for (int i = 1; i < m; i++) {
            arr[0][i] += cnt[idx++];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = Math.max(arr[i-1][j], Math.max(arr[i][j-1], arr[i-1][j-1]));
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int[] ints : arr) {
            for (int x : ints) {
                sb.append(x + 1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
