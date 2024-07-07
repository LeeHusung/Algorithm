import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int r, c, res, startX, startY, fireX, fireY;
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        arr = new char[r][c];
        res = 0;
        startX = 0;
        startY = 0;
        fireX = 0;
        fireY = 0;
        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> jihunQ = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'J') {
                    jihunQ.add(new int[]{i, j});
                }
                if (arr[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});

                }
            }
        }

        while (true) {
            res++;
            int fireSize = fireQ.size();
            for (int i = 0; i < fireSize; i++) {
                int[] p = fireQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }
                    if (arr[nx][ny] == '.' || arr[nx][ny] == 'J') {
                        arr[nx][ny] = 'F';
                        fireQ.offer(new int[]{nx, ny});
                    }
                }
            }
            int size = jihunQ.size();
            for (int i = 0; i < size; i++) {
                int[] p = jihunQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        System.out.println(res);
                        return;
                    }
                    if (arr[nx][ny] == '.') {
                        jihunQ.offer(new int[]{nx, ny});
                        arr[nx][ny] = 'J';
                    }

                }
            }
            if (jihunQ.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}
