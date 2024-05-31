import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        int[] res = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int num = Integer.parseInt(s1[0]);
            int amount = Integer.parseInt(s1[1]);
            res[num] += amount;
        }

        for (int i = 2; i <= n; i++) {
            res[i] += res[arr[i]];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);

    }

}
