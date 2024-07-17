import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    static boolean[][] ch, dp;
    static int n, m, res;
    private static boolean D(int x, int y) {
        boolean result = false;
        if (x < 0 || y < 0 || x >= n || y >= m) return true;
        if (arr[x][y] == 'T') return true;
        else if (arr[x][y] == 'F') return false;
        if (ch[x][y]) return false;
        ch[x][y] = true;
        switch (arr[x][y]) {
            case 'D': {
                result = D(x + 1, y);
                break;
            }
            case 'U': {
                result = D(x - 1, y);
                break;
            }
            case 'R': {
                result = D(x, y + 1);
                break;
            }
            case 'L': {
                result = D(x, y - 1);
                break;
            }
        }
        arr[x][y] = result ? 'T' : 'F';
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        res = 0;
        arr = new char[n][m];
        ch = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (D(i, j)) res++;
            }
        }

        System.out.println(res);

    }
}
