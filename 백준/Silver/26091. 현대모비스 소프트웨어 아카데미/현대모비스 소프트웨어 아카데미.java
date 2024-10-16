import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);
        long[] arr = new long[(int) n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int x = 0;
        int y = arr.length - 1;
        long cnt = 0;
        while (x < y) {
            long k = arr[x] + arr[y];
            if (k >= m) {
                cnt++;
                x++;
                y--;
            } else {
                x++;
            }
        }
        System.out.println(cnt);
    }
}
