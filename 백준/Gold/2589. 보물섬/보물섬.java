import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] ch;
    static char[][] arr;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] x = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = x[j];
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    ch = new int[n][m];
                    ch[i][j] = 1;
                    q.offer(new Node(i, j, 0));
                    while (!q.isEmpty()) {
                        Node p = q.poll();
                        answer = Math.max(answer, p.cnt);
                        for (int l = 0; l < 4; l++) {
                            int nx = p.x + dx[l];
                            int ny = p.y + dy[l];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] == 'L') {
                                ch[nx][ny] = 1;
                                q.offer(new Node(nx, ny, p.cnt + 1));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
