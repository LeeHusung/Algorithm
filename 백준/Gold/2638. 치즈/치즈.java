import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m, time;
    static int[][] arr, ch;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        time = 0;
        arr = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        while (!checkCheese()) {
            time++;
            //외부치즈 구하기
            findOutCheese(0, 0);
//            findHoll();
            melt();
//            base();

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 2) {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        System.out.println(time);
    }

    private static void findOutCheese(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        ch = new int[n][m];
        q.offer(new Node(x, y));
        arr[x][y] = 2;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    arr[nx][ny] = 2;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
//
//    private static void base() {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j] == 5 || arr[i][j] == -2) {
//                    arr[i][j] = 0;
//                }
//            }
//        }
//    }

//    private static void findHoll() {
////        for (int i = 0; i < arr.length; i++) {
////            Arrays.fill(arr[i], 0);
////        }
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 1; j < arr[i].length; j++) {
//                if (arr[i][j] == 0) {
//                    if (bfs(i, j)) {
//                        arr[i][j] = -2;
//                    }
//                }
//            }
//        }
//        System.out.println("=== findHoll ===");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static boolean bfs(int x, int y) {
//        q.clear();
//        for (int i = 0; i < ch.length; i++) {
//            Arrays.fill(ch[i], 0);
//        }
//        q.offer(new int[]{x, y});
//        ch[x][y] = 1;
//        while (!q.isEmpty()) {
//            int[] p = q.poll();
//            if (p[0] == 0 || p[0] == n - 1 || p[1] == 0 || p[1] == m - 1) return false;
//            for (int i = 0; i < 4; i++) {
//                int nx = p[0] + dx[i];
//                int ny = p[1] + dy[i];
//                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == 0) {
//                    ch[nx][ny] = 1;
//                    q.offer(new int[]{nx, ny});
//                }
//            }
//        }
//        return true;
//    }

    private static void melt() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 2) cnt++;
                    }
                    if (cnt >= 2) {
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    private static boolean checkCheese() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) return false;
            }
        }
        return true;
    }
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
