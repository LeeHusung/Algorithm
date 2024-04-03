import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long m = Long.parseLong(s[1]);

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int x = 1;
        int y = 1;
        long min = Long.MAX_VALUE;

        while (x <= n && y <= n) {
            if (arr[y] - arr[x] < m) {
                y++;
            } else if (arr[y] - arr[x] >= m) {
                min = Math.min(min, arr[y] - arr[x]);
                x++;
            }
        }
        System.out.println(min);
    }
}
