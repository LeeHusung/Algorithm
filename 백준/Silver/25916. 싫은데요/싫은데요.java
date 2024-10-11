import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);
        long[] arr = new long[(int)n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int x = 0;
        int y = 0;
        long sum = 0;
        long res = 0;
        while (y < n) {
            if (sum < m) {
                sum += arr[y++];
            }
            else  {
                sum -= arr[x++];
            }
//            System.out.println(x + " " + y + " " + sum);
            if (sum <= m) {
                res = Math.max(res, sum);
            }
        }
        System.out.println(res);

    }
}
