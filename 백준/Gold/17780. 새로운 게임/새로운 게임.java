import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int maxSize = Integer.MIN_VALUE;
    static ArrayList<Node>[][] arr;
    static int[][] color;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        color = new int[n][n];
        arr = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Node> nights = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]) - 1;
            int y = Integer.parseInt(s1[1]) - 1;
            int dir = Integer.parseInt(s1[2]) - 1;
            Node node = new Node(i + 1, x, y, dir);
            nights.add(node);
            arr[x][y].add(node);
        }

        int turn = 1;
        while (true) {
            if (maxSize >= 4) {
                System.out.println(turn);
                return;
            }

            for (int k = 0; k < nights.size(); k++) {
                Node night = nights.get(k);
                int x = night.x;
                int y = night.y;
                if (!arr[x][y].isEmpty() && arr[x][y].get(0).equals(night)) {
                    int nx = x + dx[night.dir];
                    int ny = y + dy[night.dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || color[nx][ny] == 2) {
                        if (night.dir == 0) {
                            night.dir = 1;
                        } else if (night.dir == 1) {
                            night.dir = 0;
                        } else if (night.dir == 2) {
                            night.dir = 3;
                        } else if (night.dir == 3) {
                            night.dir = 2;
                        }
                        if ((night.x + dx[night.dir]) < 0 || (night.x + dx[night.dir]) >= n ||
                                (night.y + dy[night.dir]) < 0 || (night.y + dy[night.dir]) >= n ||
                                (color[night.x + dx[night.dir]][night.y + dy[night.dir]]) == 2) continue;
                        nx = x + dx[night.dir];
                        ny = y + dy[night.dir];
                        if (color[nx][ny] == 1) {
                            red(x, y, nx, ny);
                            if (maxSize >= 4) {
                                System.out.println(turn);
                                return;
                            }
                            continue;
                        }
                        arr[nx][ny].addAll(arr[x][y]);
                        for (Node reversedNight : arr[x][y]) {
                            reversedNight.x = nx;
                            reversedNight.y = ny;
                        }
                        if (arr[nx][ny].size() >= 4) {
                            System.out.println(turn);
                            return;
                        }
                        arr[x][y].clear();
                    }
                    //이동한 곳이 빨간색 블록이면,
                    else if (color[nx][ny] == 1) {
                        red(x, y, nx, ny);
                        if (maxSize >= 4) {
                            System.out.println(turn);
                            return;
                        }
                    }
                    //이동한 곳이 색이 없는 블록이면,
                    else {
                        arr[nx][ny].addAll(arr[x][y]);
                        for (Node reversedNight : arr[x][y]) {
                            reversedNight.x = nx;
                            reversedNight.y = ny;
                        }
                        arr[x][y].clear();
                        maxSize = Math.max(maxSize, arr[nx][ny].size());
                        if (maxSize >= 4) {
                            System.out.println(turn);
                            return;
                        }
                    }
                }
            }
            turn++;
            if (turn > 1000) {
                System.out.println(-1);
                return;
            }
        }

    }

    private static void red(int x, int y, int nx, int ny) {
        ArrayList<Node> reversedNights = new ArrayList<>();
        for (int i = arr[x][y].size() - 1; i >= 0; i--) {
            reversedNights.add(arr[x][y].get(i));
        }
        for (Node k : reversedNights) {
            arr[nx][ny].add(k);
        }
        for (Node reversedNight : arr[x][y]) {
            reversedNight.x = nx;
            reversedNight.y = ny;
        }
        arr[x][y].clear();
        maxSize = Math.max(maxSize, arr[nx][ny].size());

    }

    static class Node {
        int num, x, y, dir;

        public Node(int num, int x, int y, int dir) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;
            Node node = (Node) object;
            return num == node.num && x == node.x && y == node.y && dir == node.dir;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, x, y, dir);
        }

    }
}
