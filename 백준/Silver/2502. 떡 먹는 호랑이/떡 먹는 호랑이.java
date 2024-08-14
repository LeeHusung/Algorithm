import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for (int i = 1; i <= 50000; i++) {
            for (int j = i; j <= 50000; j++) {
                D(3, i, j, i, j, i + j);
            }
        }

    }

    private static void D(int L, int x, int y, int one, int two, int sum) {
        if (L == n) {
            if (sum > m) return;
            if (sum == m) {
                System.out.println(x);
                System.out.println(y);
                System.exit(0);
            }
            return;
        }
        D(L + 1, x, y, two, sum, sum + two);
    }
}
