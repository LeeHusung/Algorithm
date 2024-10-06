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

        long start = 0;
        long end = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (middle / arr[i]);
                if (cnt >= m) break;

            }
            if (cnt < m) {
                start = middle + 1;
            } else {
                res = middle;
                end = middle - 1;
            }
        }
        System.out.println(res);

    }
}
