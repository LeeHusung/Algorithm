import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dl = {0, 0, 0, 0, 1, -1};
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) break;
            char[][][] arr = new char[l][r][c];
            int[][][] ch = new int[l][r][c];
            int[] start = new int[3];
            int[] end = new int[3];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        arr[i][j][k] = str.charAt(k);
                        if (arr[i][j][k] == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                        if (arr[i][j][k] == 'E') {
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                    }
                }
                br.readLine();
            }

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(start);
            ch[start[0]][start[1]][start[2]] = 1;
            int L = 0;
            boolean flag = false;
            while (!q.isEmpty()) {
                int len = q.size();
                L++;
                for (int i = 0; i < len; i++) {
                    int[] p = q.poll();

                    if (p[0] == end[0] && p[1] == end[1] && p[2] == end[2]) {
                        flag = true;
                        break;
                    }
                    for (int j = 0; j < 6; j++) {
                        int nl = p[0] + dl[j];
                        int nx = p[1] + dx[j];
                        int ny = p[2] + dy[j];
                        if (nx >= 0 && ny >= 0 && nl >= 0 && nx < r && ny < c && nl < l && ch[nl][nx][ny] == 0 && (arr[nl][nx][ny] == '.' || arr[nl][nx][ny] == 'E')) {
                            ch[nl][nx][ny] = 1;
                            q.offer(new int[]{nl, nx, ny});
                        }
                    }
                }
                if (flag) break;
            }
            if (flag) {
                System.out.println("Escaped in " + (L - 1) + " minute(s).");
            } else System.out.println("Trapped!");


        }
    }
}
