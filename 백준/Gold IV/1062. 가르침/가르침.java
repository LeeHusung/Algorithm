import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n, k, answer;
    static String[] arr, input;
    static boolean[] learned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        answer = 0;
        input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        if (k < 5) {
            System.out.println(0);
            return;
        }

        learned = new boolean[26];
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        arr = new String[]{"b", "d", "e", "f", "g", "h", "j", "k", "l",
                "m", "o", "p", "q", "r", "s", "u", "v", "w", "x",
                "y", "z"};

        D(0, 0);
        System.out.println(answer);
    }

    private static void D(int L, int start) {
        if (L == k - 5) {
            int cnt = 0;
            for (String x : input) {
                if (check(x)) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        } else {
            for (int i = start; i < arr.length; i++) {
                if (!learned[arr[i].charAt(0) - 'a']) {
                    learned[arr[i].charAt(0) - 'a'] = true;
                    D(L + 1, i + 1);
                    learned[arr[i].charAt(0) - 'a'] = false;
                }
            }
        }
    }

    private static boolean check(String x) {
        for (int i = 0; i < x.length(); i++) {
            if (!learned[x.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
