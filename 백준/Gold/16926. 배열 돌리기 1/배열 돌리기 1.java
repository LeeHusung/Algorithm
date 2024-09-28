import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(n, m) / 2;
        while (r-- > 0) {
            int nn = n;
            int nm = m;
            int x = 0;
            int y = 0;
            int nx = 0;
            int ny = 0;
            for (int i = 0; i < min; i++) {
                int k = arr[x][y];
                while (true) {
                    arr[x][y] = arr[x][y + 1];
                    y++;
                    if (y == nm - 1) break;
                }
                while (true) {
                    arr[x][y] = arr[x + 1][y];
                    x++;
                    if (x == nn - 1) break;
                }
                while (true) {
                    arr[x][y] = arr[x][y - 1];
                    y--;
                    if (y == ny) break;
                }
                while (true) {
                    arr[x][y] = arr[x - 1][y];
                    x--;
                    if (x == nx) break;
                }
                nn--;
                nm--;
                nx++;
                ny++;
                arr[x+1][y] = k;
                x++;
                y++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
