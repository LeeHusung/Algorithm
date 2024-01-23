import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, answer, max;
    static int[][] arr, ch, clone;
    static boolean flag = false;
    static List<Virus> virus = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    private static void D(int L, int start) {
        if (L == m) {
            for (int i = 0; i < n; i++) {
                clone[i] = arr[i].clone();
            }
            flag = false;
            bfs();
            if (!flag) {
                answer = Math.min(answer, max);
            }
            return;
        } else {
            for (int i = start; i < virus.size(); i++) {
                Virus v = virus.get(i);
                arr[v.x][v.y] = -1;
                D(L + 1, i + 1);
                arr[v.x][v.y] = 2;
            }
        }
    }

    private static void bfs() {
        q.clear();
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (clone[i][j] == -1) {
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                }
            }
        }
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
                        if (clone[nx][ny] == 2) {
                            ch[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                        }
                        else if (clone[nx][ny] == 0) {
                            clone[nx][ny] = L;
                            ch[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }

                }
            }
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (clone[i][j] == 0) {
                    flag = true;
                }
                if (virus.contains(new Virus(i, j))) {
                    continue;
                }
                if (ch[i][j] == 1 /*&& !virus.contains(new int[]{i, j})*/ && clone[i][j] > max) {
                    max = clone[i][j];
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        answer = Integer.MAX_VALUE;
        max = 0;
        arr = new int[n][n];
        ch = new int[n][n];
        clone = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new Virus(i, j));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            clone[i] = arr[i].clone();
        }
        D(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        } else System.out.println(answer);
    

    }

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Virus virus = (Virus) o;
            return x == virus.x && y == virus.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
