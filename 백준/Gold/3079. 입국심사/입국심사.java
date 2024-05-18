import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        long start = 0;
        long end = 0;
        long max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        end = max * m;

        Arrays.sort(arr);

        long answer = Integer.MAX_VALUE;
        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= middle) {
                    cnt += middle / arr[i];
                    if (cnt >= m) break;
                }
            }
            if (cnt >= m) {
                end = middle - 1;
                answer = middle;
            } else start = middle + 1;
        }
        System.out.println(answer);


    }
}
