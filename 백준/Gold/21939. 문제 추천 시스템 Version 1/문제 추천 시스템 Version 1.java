import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        PriorityQueue<int[]> minpq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Map<Integer, Integer> map = new HashMap<>();
        int[][] ch = new int[100001][101];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            map.put(x, y);
            maxpq.offer(new int[]{x, y});
            minpq.offer(new int[]{x, y});
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("add")) {
                int num = Integer.parseInt(s[1]);
                int hell = Integer.parseInt(s[2]);
                map.put(num, hell);
                maxpq.add(new int[]{num, hell});
                minpq.add(new int[]{num, hell});
            } else if (s[0].equals("solved")) {
                int x = Integer.parseInt(s[1]);
                Integer y = map.get(x);
                ch[x][y] = 1;
            } else {
                int num = Integer.parseInt(s[1]);
                if (num == 1) {
                    while (!maxpq.isEmpty()) {
                        int[] p = maxpq.poll();
                        if (ch[p[0]][p[1]] == 1) continue;
                        maxpq.offer(p);
                        sb.append(p[0]).append("\n");
                        break;
                    }
                } else {
                    while (!minpq.isEmpty()) {
                        int[] p = minpq.poll();
                        if (ch[p[0]][p[1]] == 1) continue;
                        minpq.offer(p);
                        sb.append(p[0]).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);

    }

}
