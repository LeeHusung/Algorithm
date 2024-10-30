import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = 0;
        int y = 0;
        int odd = 0;
        int even = 0;
        if (arr[x] % 2 == 1) {
            odd++;
        } else {
            even++;
        }
        int max = even;

        while (x <= y) {
            if (odd > k) {
                if (arr[x] % 2 == 1) odd--;
                else even--;
                x++;
            } else {
                y++;
                if (y >= n) break;
                if (arr[y] % 2 == 1) odd++;
                else even++;
                max = Math.max(max, even);
            }
        }
        System.out.println(max);

    }
}
