import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static int len, res;
    static char[] a, b;
    static int[][][] dp;
    private static int D(int L, int x, int cur) {
        if (L == len) return 1;
        if (dp[L][x][cur] != -1) {
            return dp[L][x][cur];
        }
        int count = 0;
        if (cur == 0) {
            for (int i = x; i < a.length; i++) {
                if (b[i] == str.charAt(L)) {
                    count += D(L + 1, i + 1, 1);
                }
            }
        }
        if (cur == 1) {
            for (int i = x; i < a.length; i++) {
                if (a[i] == str.charAt(L)) {
                    count += D(L + 1, i + 1, 0);
                }
            }
        }
        return dp[L][x][cur] = count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        len = str.length();
        res = 0;
        dp = new int[len + 1][a.length + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int x = D(0, 0, 0);
        int y = D(0, 0, 1);
        System.out.println(x + y);
    }
}
