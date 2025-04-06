import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        long sum = 0;
        long start = 1;
        long end = 0;
        long[] arr = new long[s];
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            end = Math.max(end, arr[i]);
        }

        long answer = Long.MAX_VALUE;


        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            for (long j : arr) {
                cnt += j / middle;
            }
//            System.out.println(middle);
            if (cnt >= c) {
                start = middle + 1;
                long z = c * middle;
                answer = Math.min(answer, sum - z);
            } else {
                end = middle - 1;
            }
        }
        System.out.println(answer);
    }
}
