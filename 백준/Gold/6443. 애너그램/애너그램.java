import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] count;
    static char[] cur;
    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            count = new int[26];
            for (int j = 0; j < input.length(); j++) {
                count[input.charAt(j) - 'a']++;
            }
            cur = new char[input.length()];
            D(0, cur.length);
        }
        System.out.println(res);
    }

    private static void D(int L, int len) {
        if (L == len) {
            StringBuilder sb = new StringBuilder();
            for (char c : cur) {
                sb.append(c);
            }
            res.append(sb).append("\n");
            return;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                count[i]--;
                cur[L] = (char) (i + 97);
                D(L + 1, len);
                count[i]++;
            }
        }
    }
}
