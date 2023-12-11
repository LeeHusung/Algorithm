import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static Point[] points;
    static int[] ch;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            points = new Point[n + 2];
            ch = new int[n + 2];

            for (int j = 0; j < n + 2; j++) {
                String[] s = br.readLine().split(" ");
                points[j] = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            }

            if (bfs()) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(points[0]);
        ch[0] = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p == points[n + 1]) return true;
            for (int i = 1; i < n + 2; i++) {
                if (ch[i] == 0 && Math.abs(p.x - points[i].x) + Math.abs(p.y - points[i].y) <= 1000) {
                    ch[i] = 1;
                    q.offer(points[i]);
                }
            }
        }
        return false;
    }
}
