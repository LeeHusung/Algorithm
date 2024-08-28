import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            k += arr[i];
        }

        int start = 0;
        int end = 0;
        int now = arr[start];
        int max = 0;
        while (start <= end && end < n) {
            int minNow = Math.min(now, k - now);
            max = Math.max(max, minNow);
            if (minNow == now) {
                end++;
                now += arr[end];
            } else {
                now -= arr[start];
                start++;
            }
        }
        System.out.println(max);



    }
}
