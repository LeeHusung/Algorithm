import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dy = {0, -1, 0, 1, 1, -1, -1, 1};
    static int[][] ch, arr;
    static int answer, w, h;
    public static void D(int x, int y) {
        if (arr[x][y] == 0) {
            return;
        } else {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && ch[nx][ny] == 0 && arr[nx][ny] == 1) {
                    ch[nx][ny] = 1;
                    D(nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            String[] split = s.split(" ");
            w = Integer.parseInt(split[0]);
            h = Integer.parseInt(split[1]);
            if (w == 0 && h == 0) break;
            if (w == 1 && h == 1) {
                if (Integer.parseInt(br.readLine()) == 0) {
                    System.out.println(0);
                    continue;
                } else {
                    System.out.println(1);
                    continue;
                }
            }

            arr = new int[h][w];
            ch = new int[h][w];
            answer = 0;
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                String[] sssplit = input.split(" ");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(sssplit[j]);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 1 && ch[i][j] == 0) {
                        ch[i][j] = 1;
                        answer++;
                        D(i, j);
                    }
                }
            }
            System.out.println(answer);

        }

    }
}
