import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[n + 1];
        sum[1] = arr[1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int cnt = 0; cnt < m; cnt++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sum[j] - sum[i-1]).append("\n");
        }
        System.out.println(sb);

    }
}
