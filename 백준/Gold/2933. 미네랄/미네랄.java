import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int r, c, n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                if (str.charAt(j) == '.') arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            count[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < n; i++) {
            int height = count[i];
            if (i % 2 == 0) { //왼쪽부터 탐색
                for (int j = 0; j < c; j++) {
                    if (arr[r - height][j] == 1) {
                        arr[r - height][j] = 0;
                        break;
                    }
                }
            } else { //오른쪽부터 탐색
                for (int j = c - 1; j >= 0; j--) {
                    if (arr[r - height][j] == 1) {
                        arr[r - height][j] = 0;
                        break;
                    }
                }
            }
            down();

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) sb.append("x");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    private static void down() {
//        print();
        Queue<Point> q = new ArrayDeque<>();
        List<Point> cluster = new ArrayList<>();
        int[][] ch = new int[r][c];
        PriorityQueue<Point> list = new PriorityQueue<>();
        for (int j = 0; j < c; j++) {
            if (arr[r - 1][j] == 0 || ch[r - 1][j] == 1) continue;
            ch[r - 1][j] = 1;
            q.offer(new Point(r - 1, j));
            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && ch[nx][ny] == 0 && arr[nx][ny] == 1) {
                        q.offer(new Point(nx, ny));
                        ch[nx][ny] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                if (ch[i][k] == 0 && arr[i][k] == 1) {
                    arr[i][k] = 0;
                    cluster.add(new Point(i, k));
                }
            }
        }
        if (cluster.isEmpty()) return;
        boolean flag = true;
        while (flag) {
            for (Point point : cluster) {
                int nx = point.x + 1;
                int ny = point.y;
                if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (Point point : cluster) {
                    point.x++;
                }
            }
        }
        for (Point point : cluster) {
            arr[point.x][point.y] = 1;
        }
    }


    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Point o) {
            return o.x - this.x;
        }
    }
}
