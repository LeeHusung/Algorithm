import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr, ch;
    static int r, c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] sheepAndWolf = new int[2];
    public static void D(int x, int y) {
//        System.out.println(x + " " + y);
        if (arr[x][y] == 2) sheepAndWolf[0]++;
        if (arr[x][y] == 3) sheepAndWolf[1]++;
        ch[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c && ch[nx][ny] == 0 && arr[nx][ny] != 1) {
                ch[nx][ny] = 1;
                D(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        arr = new int[r][c];
        ch = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < c; j++) {
                if (s1.charAt(j) == '.') {
                    arr[i][j] = 0;
                }
                if (s1.charAt(j) == '#') {
                    arr[i][j] = 1;
                }
                if (s1.charAt(j) == 'o') {
                    arr[i][j] = 2;
                }
                if (s1.charAt(j) == 'v') {
                    arr[i][j] = 3;
                }
            }
        }

        int[] answer = new int[2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((arr[i][j] == 2 || arr[i][j] == 3) && ch[i][j] == 0) {
                    D(i, j);

                    if (sheepAndWolf[0] > sheepAndWolf[1]) {
                        answer[0] += sheepAndWolf[0];
                    } else {
                        answer[1] += sheepAndWolf[1];
                    }
                    sheepAndWolf[0] = 0;
                    sheepAndWolf[1] = 0;
                }
            }
        }
        for (int x : answer) {
            System.out.print(x + " ");
        }


    }
}
