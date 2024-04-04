import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean flag = false;
    static int w, h, res, cnt, star;
    static int[] real, first, start, ch2;
    static int[][] arr, ch;
    static int[][][][] dist;
    static List<int[]> list = new ArrayList<>();
    static LinkedList<int[]> copy = new LinkedList<>();
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    private static void D(int L) {
        if (L == cnt) {
            int answer = 0;
            for (int[] x : copy) {
                answer += dist[first[0]][first[1]][x[0]][x[1]];
                first[0] = x[0];
                first[1] = x[1];
            }
            res = Math.min(res, answer);
            first = real.clone();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (ch2[i] == 0) {
                ch2[i] = 1;
                copy.add(list.get(i));
                D(L + 1);
                copy.pollLast();
                ch2[i] = 0;
            }
        }
    }

    private static void bfs(int[] start) {
        q.offer(start);
        ch[start[0]][start[1]] = 1;
        for (int i = 0; i < h; i++) {
            Arrays.fill(ch[i], 0);
        }
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (arr[p[0]][p[1]] == 1) {
                    dist[start[0]][start[1]][p[0]][p[1]] = L;
                    dist[p[0]][p[1]][start[0]][start[1]] = L;
                    star++;
                    flag = true;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w && ch[nx][ny] == 0 && arr[nx][ny] != 2) {
                        ch[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);
            res = Integer.MAX_VALUE;
            cnt = 0;
            star = 0;
            if (w == 0 && h == 0) break;
            arr = new int[h][w];
            ch = new int[h][w];
            start = new int[2];
            first = new int[2];
            real = new int[2];
            dist = new int[21][21][21][21];
            for (int i = 0; i < h; i++) {
                String[] s1 = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    String str = s1[j];
                    if (str.equals("o")) {
                        arr[i][j] = -1;
                        start[0] = i;
                        start[1] = j;
                        first[0] = i;
                        first[1] = j;
                        real[0] = i;
                        real[1] = j;
                    }
                    if (str.equals("*")) {
                        list.add(new int[]{i, j});
                        cnt++;
                        arr[i][j] = 1;
                    }
                    if (str.equals("x")) arr[i][j] = 2;
                }
            }
            ch2 = new int[cnt];
            boolean z = false;
            for (int i = 1; i < cnt + 1; i++) {
                bfs(start);
                if (i == 1 && star != cnt) {
                    z = true;
                    break;
                }
                start = list.get(i-1);
            }
            if (z) {
                System.out.println(-1);
                list.clear();
                copy.clear();
                flag = false;
                continue;
            }
            D(0);

            System.out.println(res);
            list.clear();
            copy.clear();
            flag = false;
        }
    }

}
