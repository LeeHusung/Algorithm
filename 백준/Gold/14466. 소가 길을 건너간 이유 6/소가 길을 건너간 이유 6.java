import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long max = 0;
    static long cnt = 0;
    static int n, k, r;
    static int[][] arr;
    static List<Cow> cowList = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] cowArr;
    static Queue<Cow> q = new ArrayDeque<>();
    static int[][] ch;
    static boolean[][][][] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        arr = new int[n][n];
        ch = new int[n][n];
        cowArr = new int[n][n];
        road = new boolean[n][n][n][n];
        long sum = 0;
        long idx = 1;
        for (int i = 1; i < k; i++) {
            sum += idx++;
        }
        max = sum;
//        System.out.println(sum);

        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int prex = Integer.parseInt(st.nextToken()) - 1;
            int prey = Integer.parseInt(st.nextToken()) - 1;
            int nextx = Integer.parseInt(st.nextToken()) - 1;
            int nexty = Integer.parseInt(st.nextToken()) - 1;
            road[prex][prey][nextx][nexty] = true;
            road[nextx][nexty][prex][prey] = true;
        }
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cowx = Integer.parseInt(st.nextToken()) - 1;
            int cowy= Integer.parseInt(st.nextToken()) - 1;
            cowArr[cowx][cowy] = 1;
            cowList.add(new Cow(cowx, cowy));
        }

        for (Cow cow : cowList) {
            Queue<Cow> q = new ArrayDeque<>();
            ch = new int[n][n];
            q.offer(cow);
            ch[cow.x][cow.y] = 1;
            while (!q.isEmpty()) {
                Cow p = q.poll();
//                System.out.println(p.x + " " + p.y);
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
                        if (road[p.x][p.y][nx][ny]) {
                            continue;
                        }
                        if (cowArr[nx][ny] == 1) {
//                            System.out.println(p.x + " " + p.y + " " + nx + " " + ny);
                            cnt++;
                        }
                        ch[nx][ny] = 1;
                        q.offer(new Cow(nx, ny));
                    }
                }
            }
        }
//        System.out.println(max);
//        System.out.println(cnt);
        System.out.println(max - (cnt / 2));

//        for (int i = 0; i < cowList.size() - 1; i++) {
//            Cow firstCow = cowList.get(i);
//            for (int j = i + 1; j < cowList.size(); j++) {
//                Cow secondCow = cowList.get(j);
//                bfs(firstCow, secondCow);
//            }
//        }
//        System.out.println(max);
    }

//    private static void bfs(final Cow firstCow, final Cow secondCow) {
//        q.clear();
//        ch = new int[n][n];
//        q.offer(firstCow);
//        ch[firstCow.x][firstCow.y] = 1;
//        while (!q.isEmpty()) {
//            Cow cow = q.poll();
//            if (cow.equals(secondCow)) {
//                max--;
//                return;
//            }
//            for (int i = 0; i < 4; i++) {
//                int nx = cow.x + dx[i];
//                int ny = cow.y + dy[i];
//                if (roadList.contains(new Road(cow.x, cow.y, nx, ny))) {
//                    continue;
//                }
//                if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
//                    ch[nx][ny] = 1;
//                    q.offer(new Cow(nx, ny));
//                }
//            }
//        }
//    }

    static class Road {
        int prex;
        int prey;
        int nextx;
        int nexty;

        public Road(final int prex, final int prey, final int nextx, final int nexty) {
            this.prex = prex;
            this.prey = prey;
            this.nextx = nextx;
            this.nexty = nexty;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Road road = (Road) o;
            return prex == road.prex && prey == road.prey && nextx == road.nextx && nexty == road.nexty;
        }

        @Override
        public int hashCode() {
            return Objects.hash(prex, prey, nextx, nexty);
        }
    }

    static class Cow {
        int x;
        int y;

        public Cow(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cow cow = (Cow) o;
            return x == cow.x && y == cow.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
