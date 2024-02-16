import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        long answer = 0;
        long start = 1;
        long end = 0;
        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            end = Math.max(end, arr[i]);
        }

        while (start <= end) {
            long middle = (start + end) / 2;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                cnt += (int)(arr[i] / middle);
            }
            if (cnt >= n) {
                answer = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println(answer);

    }
}
