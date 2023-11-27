import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            int x = Integer.parseInt(split[0]) - 1;
            int y = Integer.parseInt(split[1]) - 1;
            arr[x][y] = 1;
        }

        Map<Integer, String> map = new HashMap<>();
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            int x = Integer.parseInt(split[0]);
            String c = split[1];
            map.put(x, c);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0;

        LinkedList<int[]> list = new LinkedList<>();
        int t = 0;
        int[] start = {0, 0};
        list.offer(start);
        while (!list.isEmpty()) {
            t++;
            int[] p = list.peekLast();
            int nx = p[0] + dx[d];
            int ny = p[1] + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            for (int[] x : list) {
                if (x[0] == nx && x[1] == ny) {
                    System.out.println(t);
                    return;
                }
            }
            list.add(new int[]{nx, ny});
            if (arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
            } else if (arr[nx][ny] == 0) {
                list.pollFirst();
            }
            if (map.containsKey(t)) {
                String s = map.get(t);
                if (s.equals("D")) {
                    d = (d + 1) % 4;
                } else if (s.equals("L")) d = (d + 3) % 4;
            }
        }
        System.out.println(t);
    }
}
