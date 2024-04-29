import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m, answer;
    static int[] arr, cur, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n];
        cur = new int[n];
        ch = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        answer = 0;
        D(0);
        System.out.println(answer);
    }

    private static void D(int L) {
        if (L == n) {
            int x = 500;
            for (int i = 0; i < cur.length; i++) {
                x -= m;
                x += arr[cur[i]-1];
                if (x < 500) return;
            }
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                cur[L] = i + 1;
                D(L + 1);
                ch[i] = 0;
            }
        }
    }
}
