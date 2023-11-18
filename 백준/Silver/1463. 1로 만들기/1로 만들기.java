import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int x;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();

        if (x == 1) {
            System.out.println(0);
            return;
        }
        int cnt = bfs();

        System.out.println(cnt + 1);
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int[] ch = new int[x + 1];
        ch[1] = 1;

        int cnt = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int p = q.poll();
                int nx = p * 3;
                int ny = p * 2;
                int nz = p + 1;
                if (nx == x || ny == x || nz == x) return cnt;
                if (nx < x && ch[nx] == 0) {
                    ch[nx] = 1;
                    q.offer(nx);
                }
                if (ny < x && ch[ny] == 0) {
                    ch[ny] = 1;
                    q.offer(ny);
                }
                if (nz < x && ch[nz] == 0) {
                    ch[nz] = 1;
                    q.offer(nz);
                }
            }
            cnt++;
        }
        return cnt;
    }
}
