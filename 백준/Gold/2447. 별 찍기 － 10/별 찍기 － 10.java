import java.io.*;

public class Main {
    //https://st-lab.tistory.com/95
    static char[][] carr;
    private static void D(int x, int y, int n, boolean blank) {
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    carr[i][j] = ' ';
                }
            }
            return;
        }
        if (n == 1) {
            carr[x][y] = '*';
            return;
        }
        int size = n / 3;
        int cnt = 0;
        for (int i = x; i < x + n; i+=size) {
            for (int j = y; j < y + n; j+=size) {
                cnt++;
                if (cnt == 5) D(i, j, size, true);
                else D(i, j, size, false);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        carr = new char[n][n];
        D(0, 0, n, false);
        for (int i = 0; i < carr.length; i++) {
            bw.write(carr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
