import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int k = Integer.parseInt(s1[2]);
            res[a-1] += k;
            res[b] -= k;
        }
        int[] sum = new int[n + 1];

        sum[0] = res[0];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + res[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] += sum[i];
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
