import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean isNone;
    static int n, m, answer;
    static int[][] arr;
    static List<int[]> canPutVirus = new ArrayList<>();
    static LinkedList<int[]> virus = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][n];
        answer = Integer.MAX_VALUE;
        isNone = false;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) canPutVirus.add(new int[]{i, j});
                if (arr[i][j] == 1) arr[i][j] = -1;
            }
        }

        D(0, 0);
        if (!isNone) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void D(int L, int start) {
        if (L == m) {
            int max = bfs();
            if (max != -1) {
                isNone = true;
                answer = Math.min(answer, max);
            }
            return;
        }
        for (int i = start; i < canPutVirus.size(); i++) {
            virus.add(canPutVirus.get(i));
            D(L + 1, i + 1);
            virus.pollLast();
        }
    }

    private static int bfs() {
        int[][] tmp = new int[n][n];
        int[][] ch = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) tmp[i] = arr[i].clone();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 2) tmp[i][j] = 0;
            }
        }
        for (int[] x : virus) {
            q.offer(x);
            ch[x[0]][x[1]] = 1;
        }
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && tmp[nx][ny] != -1) {
                        ch[nx][ny] = 1;
                        tmp[nx][ny] = L;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 0) {
                    boolean flag = false;
                    for (int[] x : virus) {
                        if (i == x[0] && j == x[1]) {
                            flag = true;
                        }
                    }
                    if (!flag) return -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, tmp[i][j]);
            }
        }
        return max;
    }

}
