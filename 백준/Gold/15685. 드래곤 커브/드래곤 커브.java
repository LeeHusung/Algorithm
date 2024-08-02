import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ch = new int[101][101];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            mark(x, y, getDistance(d, g));
        }
        int cnt = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (ch[i][j] == 0) continue;
                if (ch[i - 1][j] == 1 && ch[i][j - 1] == 1 && ch[i - 1][j - 1] == 1) {
                   cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    private static List<Integer> getDistance(int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);
        while (g --> 0) {
            int len = list.size();
            for (int i = len - 1; i >= 0; i--) {
                list.add((list.get(i) + 1) % 4);
            }
        }
        return list;
    }

    private static void mark(int x, int y, List<Integer> distance) {
        ch[x][y] = 1;
        for (int i = 0; i < distance.size(); i++) {
            Integer dir = distance.get(i);
            switch (dir) {
                case 0: x++;
                        ch[x][y] = 1;
                        break;
                case 1: y--;
                        ch[x][y] = 1;
                        break;
                case 2: x--;
                        ch[x][y] = 1;
                        break;
                case 3: y++;
                        ch[x][y] = 1;
                        break;
            }
        }
    }
}
