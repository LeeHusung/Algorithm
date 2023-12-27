import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m, answer;
    static int[][] arr;
    static int[] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    private static void D(int L, int x, int y) {
        if (ch[arr[x][y]] == 1) {
            answer = Math.max(L, answer);
            return;
        }

        ch[arr[x][y]] = 1;
        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                D(L + 1, nx, ny);
            }
        }
        ch[arr[x][y]] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        answer = 1;
        ch = new int[100];
        arr = new int[21][21];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = split[j].charAt(0) - 'A';
            }
        }
        D(0, 0, 0);
        System.out.println(answer);

    }
}
