import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int s = Integer.parseInt(s1[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long max = Long.MAX_VALUE;
        int x = 0;
        int y = 0;
        long sum = 0;
        while (true) {
            if (sum >= s) {
                max = Math.min(max, y - x);
                sum -= arr[x++];
            } else if (y == n) break;
            else if (sum < s && y < n){
                sum += arr[y];
                y++;
            }
        }
        if (max == Long.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(max);

    }
}