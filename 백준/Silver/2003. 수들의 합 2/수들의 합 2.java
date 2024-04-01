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

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int x = 0;
        int y = 0;
        int sum = 0;
        while (y <= n && x < n) {
            if (sum == m) {
                cnt++;
                sum += arr[y++];
            } else if (sum > m) {
                sum -= arr[x++];
            } else {
                sum += arr[y];
                y++;
            }
        }
        System.out.println(cnt);
    }
}
