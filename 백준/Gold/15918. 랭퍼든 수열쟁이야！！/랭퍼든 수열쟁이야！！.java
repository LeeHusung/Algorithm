import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, x, y, answer;
    static int[] res, ch;

    public static void D(int L) {
        if (L > 2 * n) {
            if (res[x] == res[y] && res[x] != 0) {
                answer++;
            }
            return;
        }
        if (res[L] != 0) D(L + 1);
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0 && L + i + 1 < res.length && res[L + i + 1] == 0) {
                    ch[i] = 1;
                    res[L] = i;
                    res[L + i + 1] = i;
                    D(L + 1);
                    ch[i] = 0;
                    res[L] = 0;
                    res[L + i + 1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        x = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);
        answer = 0;
        res = new int[n * 2 + 1];
        ch = new int[n + 1];
        res[x] = y - x - 1;
        res[y] = y - x - 1;
        ch[y - x - 1] = 1;

        D(1);
        System.out.println(answer);
    }
}
