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

        int[] arr = new int[n + 1];
        int[] ch = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int x = 0;
        int y = 0;

        while (y <= n) {
            ch[arr[y]]++;
            max = Math.max(max, y - x);
            while (ch[arr[y]] > k) {
                ch[arr[x]]--;
                x++;
            }
            y++;

        }
        System.out.println(max);
    }
}
