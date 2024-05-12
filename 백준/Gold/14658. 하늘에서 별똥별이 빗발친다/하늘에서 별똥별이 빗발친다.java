import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n, m, l, k;
    static List<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        l = Integer.parseInt(s[2]);
        k = Integer.parseInt(s[3]);

        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            list.add(new Point(x, y));
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                max = Math.max(max, count(list.get(i), list.get(j), k));
            }
        }
        System.out.println(k - max);

    }

    private static int count(Point x, Point y, int k) {
        int weightX = Math.max(x.x, y.x);
        int weightY = Math.min(x.y, y.y);
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (list.get(i).x <= weightX && weightX - list.get(i).x <= l && list.get(i).y >= weightY && list.get(i).y - weightY <= l) {
                cnt++;
            }
        }
        return cnt;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
