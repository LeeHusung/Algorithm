import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[][] arr, ch, clone;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 0, 1, 1, 0, -1, -1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[8][8];
        clone = new int[8][8];
        for (int i = 0; i < 8; i++) {
            clone[i] = arr[i].clone();
        }
        ch = new int[8][8];
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) == '#') {
                    arr[i][j] = 1;
                }
            }
        }
        int[] start = {7, 0};
//        ch[7][0] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int len = q.size();
            ch = new int[8][8];
            for (int j = 0; j < len; j++) {
                int[] p = q.poll();
                if (arr[p[0]][p[1]] == 1) {
                    continue;
                }
                if (p[0] == 0 && p[1] == 7) {
                    System.out.println(1);
                    return;
                }
//                System.out.println(p[0] + " " + p[1]);
//                if (p[0] == 0) {
//                    flag = true;
//                    break;
//                }
                for (int i = 0; i < 9; i++) {
                    int nx = p[0] + dx[i];
                    int ny = p[1] + dy[i];
                    if (!isValid(nx, ny)) {
                        continue;
                    }
                    q.offer(new int[]{nx, ny});
                    ch[nx][ny] = 1;
                }
            }
            down();
        }

        System.out.println(0);
    }

    private static void down() {
        for (int i = 8 - 2; i >= 0; i--) {
            for (int j = 0; j < 8; j++)
                arr[i + 1][j] = arr[i][j];
        }

        for (int i = 0; i < 8; i++)
            arr[0][i] = 0;
    }

    private static boolean isValid(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8 || arr[nx][ny] == 1 || ch[nx][ny] == 1) {
            return false;
        }
        return true;
    }
}
