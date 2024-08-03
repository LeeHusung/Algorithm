import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            long cnt = 0;
            int x = 0;
            int y = n - 1;
            long res = Long.MAX_VALUE;
            while (x < y) {
                long sum = (arr[x] + arr[y]);
                if (Math.abs(k - sum) == res) {
                    res = Math.abs(k - sum);
                    cnt++;
                } else if (Math.abs(k - sum) < res) {
                    res = Math.abs(k - sum);
                    cnt = 1;
                }
                if (sum < k) {
                    x++;
                } else y--;

            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
