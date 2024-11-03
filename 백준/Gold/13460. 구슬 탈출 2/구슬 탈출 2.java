import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import org.w3c.dom.Node;

//gold 1
//구현 시뮬레이션 bfs
//시간: 11:00 ~
public class Main {

    static int n, m;
    static char[][] arr;
    static int[] hole = new int[2];
    static int rx, ry, bx, by;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'O') {
                    hole[0] = i;
                    hole[1] = j;
                }
                if (arr[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (arr[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        List<Node> ch = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(rx, ry, bx, by));
        ch.add(new Node(rx, ry, bx, by));

        int L = 0;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            if (L > 10) {
                System.out.println(-1);
                return;
            }
            for (int z = 0; z < len; z++) {
                Node p = q.poll();
                int rpx = p.rx;
                int rpy = p.ry;
                int bpx = p.bx;
                int bpy = p.by;
                for (int i = 0; i < 4; i++) {
                    int nrx = rpx, nry = rpy;
                    int nbx = bpx, nby = bpy;
                    while (arr[nrx + dx[i]][nry + dy[i]] != '#' && arr[nrx][nry] != 'O') {
                        nrx += dx[i];
                        nry += dy[i];
                    }
                    while (arr[nbx + dx[i]][nby + dy[i]] != '#' && arr[nbx][nby] != 'O') {
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    if (arr[nbx][nby] == 'O') {
                        continue;
                    }
                    if (arr[nrx][nry] == 'O') {
                        System.out.println(L);
                        return;
                    }
                    if (nrx == nbx && nry == nby) {
                        if ((Math.abs(nrx - rpx) + Math.abs(nry - rpy)) > (Math.abs(nbx - bpx) + Math.abs(nby - bpy))) {
                            nrx -= dx[i];
                            nry -= dy[i];
                        } else {
                            nbx -= dx[i];
                            nby -= dy[i];
                        }
                    }
                    Node node = new Node(nrx, nry, nbx, nby);
                    if (!ch.contains(node)) {
                        q.offer(node);
                        ch.add(node);
                    }
                }
            }
        }
        System.out.println(-1);

    }

    static class Node {

        int rx;
        int ry;
        int bx;
        int by;

        public Node(final int rx, final int ry, final int bx, final int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return rx == node.rx && ry == node.ry && bx == node.bx && by == node.by;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rx, ry, bx, by);
        }
    }

}
