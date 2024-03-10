import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        int left = 0;
        int right = n-1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] res = new long[2];
        long answer = Long.MAX_VALUE;
        while (left < right) {
            long x = arr[left] + arr[right];
            if (x > 0) {
                if (answer > Math.abs(x)) {
                    res[0] = arr[left];
                    res[1] = arr[right];
                    answer = Math.abs(x);
                }
                right--;
            } else {
                if (answer > Math.abs(x)) {
                    res[0] = arr[left];
                    res[1] = arr[right];
                    answer = Math.abs(x);
                }
                left++;
            }
        }
        long sum = 0;
        for (long x : res) {
            sum += x;
        }

        System.out.println(sum);
    }
}