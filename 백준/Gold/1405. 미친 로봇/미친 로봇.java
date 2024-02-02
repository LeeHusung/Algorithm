import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static double n, answer;
    static double[] percent;
    static int[][] ch;
    static int[] direction;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void D(int L, int x, int y, double probabl) {
        if (L == n) {
            answer += probabl;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                D(L + 1, nx, ny, probabl * percent[i]);
                ch[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        ch = new int[29][29];
        percent = new double[4];
        for (int i = 1; i < s.length; i++) {
            percent[i - 1] = Integer.parseInt(s[i]) / 100.0;
        }
        answer = 0.0;
        ch[14][14] = 1;

        D(0, 14, 14, 1.0);
        System.out.println(answer);
    }

}
