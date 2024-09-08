import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long n = Integer.parseInt(s[0]);
        long k = Integer.parseInt(s[1]);
        long start = 0;
        long end = 1000000001;
        long[] arr = new long[(int)n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
//            end = Math.max(end, arr[i]);
        }
        Arrays.sort(arr);
        long max = 0;
        while (start <= end) {
            long middle = (start + end) / 2;
//            System.out.println(middle);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > middle) break;
                if (arr[i] <= middle) {
                    sum += middle - arr[i];
                }
            }
            if (sum <= k) {
                max = Math.max(max, middle);
                start = middle + 1;
            } else end = middle - 1;

        }

        System.out.println(max);


    }
}
