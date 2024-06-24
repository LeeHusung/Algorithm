import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int[] cap = new int[n];
        Arrays.fill(cap, c);

        int answer = 0;
        for (int[] x : arr) {
            int start = x[0];
            int end = x[1];
            int box = x[2];
            int min = c;
            for (int i = start; i < end; i++) {
                min = Math.min(min, Math.min(cap[i], box));
            }
            for (int i = start; i < end; i++) {
                cap[i] -= min;
            }
            answer += min;
        }
        System.out.println(answer);
    }

}
