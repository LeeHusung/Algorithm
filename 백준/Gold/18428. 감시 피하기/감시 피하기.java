import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean flag = false;
    static int[][] arr, ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ch = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                String input = st.nextToken();
                if (input.equals("X")) arr[i][j] = 0; //빈칸
                else if (input.equals("S")) arr[i][j] = 1; //학생
                else if (input.equals("T")) arr[i][j] = 2; //선생
            }
        }

        D(0);
        System.out.println("NO");
    }

    private static void D(int L) {
        if (L == 3) {
            if (check()) {
                System.out.println("YES");
                System.exit(0);
                return;
            }
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = 5; //장애물
                        D(L + 1);
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    private static boolean check() {
        int dir = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    int x = i;
                    int y = j;
                    int cnt = 0;
                    while (true) {
                        if (cnt == 4) break;
                        x = x + dx[dir];
                        y = y + dy[dir];
                        if (x < 0 || y < 0 || x >= n || y >= n || arr[x][y] == 5 ) {
                            x = i;
                            y = j;
                            dir = (dir + 1) % 4;
                            cnt++;
                            continue;
                        }
                        if (arr[x][y] == 1) return false;

                    }
                }
            }
        }

        return true;
    }
}
