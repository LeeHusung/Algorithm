import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr = new char[5][9];
    static int[][] ch = new int[5][9];
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min;
    static int cur;
    static int move;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            for (int i = 0; i < 5; i++) {
                Arrays.fill(ch[i], 0);
            }
            min = Integer.MAX_VALUE;
            cur = 0;
            move = 0;
            for (int i = 0; i < 5; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = charArray[j];
                    if (arr[i][j] == 'o') {
                        cur++;
                    }
                }
            }
            D(0);
            sb.append(min).append(" ").append(move).append("\n");
            br.readLine();
//            System.out.println(min);
        }
        System.out.println(sb);




    }

    private static void D(int L) {

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 'o') {
                    cnt++;
                }
            }
        }
        if (cnt < min) {
            min = cnt;
            move = cur - min;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 'o') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx + dx[k] >= 0 && ny + dy[k] >= 0 && nx + dx[k] < 5 && ny + dy[k] < 9 && arr[nx][ny] == 'o' && arr[nx + dx[k]][ny + dy[k]] == '.') {
                            arr[nx + dx[k]][ny + dy[k]] = 'o';
                            arr[nx][ny] = '.';
                            arr[i][j] = '.';
                            D(L + 1);
                            arr[nx + dx[k]][ny + dy[k]] = '.';
                            arr[nx][ny] = 'o';
                            arr[i][j] = 'o';
                        }
                    }

                }
            }
        }
    }
}
