import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, x, y, answer;
    static int[] arr, res;
    static boolean[] used;

    public static void D(int L) {
        if (L > 2*n) {
            if (res[x] == res[y] && res[x] != 0) {
                answer++;
            }
            return;
        }
        if (res[L] != 0) {
            D(L + 1);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!used[i] && L + i + 1 <= 2*n && res[L + i + 1] == 0) {
                    used[i] = true;
                    res[L] = res[L + i + 1] = i;
                    D(L + 1);
                    used[i] = false;
                    res[L] = res[L + i + 1] = 0;
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
        res = new int[2*n+1];
        used = new boolean[n+1];
        D(1);
        System.out.println(answer);
    }
}
