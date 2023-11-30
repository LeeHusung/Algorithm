import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] arr, ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        arr = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int startX = Integer.parseInt(s[0]);
            int startY = Integer.parseInt(s[1]);
            int endX = Integer.parseInt(s[2]);
            int endY = Integer.parseInt(s[3]);
            for (int j = startY; j < endY; j++) {
                for (int l = startX; l < endX; l++) {
                    arr[j][l] = 1;
                }
            }
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int cnt = 0;
                if (arr[i][j] == 0 && ch[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    while (!q.isEmpty()) {
                        cnt++;
                        int[] p = q.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = p[0] + dx[l];
                            int ny = p[1] + dy[l];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0 && ch[nx][ny] == 0) {
                                ch[nx][ny] = 1;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int x : list) {
            System.out.print(x + " ");
        }
    }
}
