import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] res;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void D(int L) {
        if (L == m) {
            for (int x : res) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                res[L] = i;
                D(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        res = new int[m];

        D(0);
        System.out.println(sb);
    }
}
