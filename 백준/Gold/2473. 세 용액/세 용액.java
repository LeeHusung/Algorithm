import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = Long.MAX_VALUE;
        Arrays.sort(arr);
        int[] res = new int[3];
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            long x = arr[i];
            while (start < end) {
                long k = arr[start] + arr[end];
                long z = x + k;
                if (Math.abs(sum) > Math.abs(z)) {
                    sum = z;
                    res[0] = arr[i];
                    res[1] = arr[start];
                    res[2] = arr[end];
                }
                if (z < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
