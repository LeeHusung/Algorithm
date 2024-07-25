import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static Node[][] arr;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int[][][] prior;
    static Queue<Node> q = new ArrayDeque<>();
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        arr = new Node[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new Node(0, 0, 0, 0, 0, false);
            }
        }

        prior = new int[m + 1][5][5];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j].num = x;
            }
        }

        String[] s1 = br.readLine().split(" ");
        int[] dir = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dir[i] = Integer.parseInt(s1[i - 1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j].x = i;
                arr[i][j].y = j;
                if (arr[i][j].num != 0) {
                    arr[i][j].dir = dir[arr[i][j].num];
                    arr[i][j].smell = k;
                    q.offer(arr[i][j]);
                    arr[i][j].isShark = true;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < 5; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int l = 1; l < 5; l++) {
                    prior[i][j][l] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int L = 0;
        while (!q.isEmpty()) {
            L++;
            if (L > 1000) {
                System.out.println(-1);
                return;
            }

            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node node = q.poll();

                boolean moved = false;
                for (int j = 1; j <= 4; j++) {
                    int nx = node.x + dx[prior[node.num][node.dir][j]];
                    int ny = node.y + dy[prior[node.num][node.dir][j]];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny].smell == 0) {
                        list.add(new Node(nx, ny, node.num, prior[node.num][node.dir][j], k, node.isShark));
                        arr[node.x][node.y].isShark = false;
                        moved = true;
                        break;
                    }
                }

                if (!moved) {
                    for (int j = 1; j <= 4; j++) {
                        int nx = node.x + dx[prior[node.num][node.dir][j]];
                        int ny = node.y + dy[prior[node.num][node.dir][j]];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny].num == node.num) {
                            list.add(new Node(nx, ny, node.num, prior[node.num][node.dir][j], k, node.isShark));
                            arr[node.x][node.y].isShark = false;
                            break;
                        }
                    }
                }
            }

            move();
            list.clear();
            down();

            if (check()) {
                System.out.println(L);
                return;
            }
        }
    }

    private static void down() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j].isShark && arr[i][j].smell != 0) {
                    arr[i][j].smell--;
                    if (arr[i][j].smell == 0) {
                        arr[i][j].num = 0;
                        arr[i][j].dir = 0;
                    }
                }
            }
        }
    }

    private static void move() {
        for (Node node : list) {
            if (arr[node.x][node.y].isShark && arr[node.x][node.y].num > node.num) {
                arr[node.x][node.y].num = node.num;
                arr[node.x][node.y].dir = node.dir;
                arr[node.x][node.y].smell = k;
                arr[node.x][node.y].isShark = true;
            } else if (!arr[node.x][node.y].isShark) {
                arr[node.x][node.y].num = node.num;
                arr[node.x][node.y].dir = node.dir;
                arr[node.x][node.y].smell = k;
                arr[node.x][node.y].isShark = true;
            }
        }
        q.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].isShark) {
                    q.offer(arr[i][j]);
                }
            }
        }
    }

    private static boolean check() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].isShark) {
                    cnt++;
                }
            }
        }
        return cnt == 1;
    }

    static class Node {
        int x, y, num, dir, smell;
        boolean isShark;

        public Node(int x, int y, int num, int dir, int smell, boolean isShark) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.smell = smell;
            this.isShark = isShark;
        }
    }
}
