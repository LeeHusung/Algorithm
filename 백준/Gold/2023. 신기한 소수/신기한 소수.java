import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder res = new StringBuilder();
    static void D(int L, String str) {
        if (!str.equals("")) {
            if (!check(str)) return;
            if (L == n && str.length() == n) {
                res.append(str).append("\n");
                return;
            }
        }
        for (int i = 1; i <= 9; i++) {
            D(L + 1, str + i);
        }
    }

    private static boolean check(String substring) {
        int ch = Integer.parseInt(substring);
        if (ch == 1) return false;
        if (ch == 2 || ch == 3) return true;
        for (int i = 2; i <= Math.sqrt(ch); i++) {
            if (ch % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        D(0, "");
        System.out.println(res);
    }
}