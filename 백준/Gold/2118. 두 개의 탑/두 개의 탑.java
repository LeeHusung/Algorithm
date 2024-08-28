import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            k += arr[i];
        }
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        max = Math.max(max, Math.min(sum[0], k - sum[0]));

        for (int i = 1; i < n; i++) {
            int x = sum[i];
            for (int j = i - 1; j >= 0; j--) {
                int y = sum[j];
                max = Math.max(max, Math.min(x - y, k - (x - y)));
            }
        }

        System.out.println(max);
    }
}
