import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] arr = new int[m][2];
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

            int[] ch = new int[n + 1];
            for (int[] x : arr) {
                int start = x[0];
                int end = x[1];
                for (int i = start; i <= end; i++) {
                    if (ch[i] == 0) {
                        ch[i] = 1;
                        break;
                    }
                }
            }
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) answer++;
            }
            System.out.println(answer);

        }
    }
}
