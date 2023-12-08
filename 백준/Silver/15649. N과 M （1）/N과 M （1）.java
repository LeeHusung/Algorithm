import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] res, ch;
    static int n, m;
    public static void D(int L) {
        if (L == m) {
            for (int x : res) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    res[L] = i;
                    D(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        res = new int[m];
        ch = new int[n + 1];

        D(0);

    }
}
