import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String res = "123456780";
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = "";
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                init += st.nextToken();
            }
        }

        map.put(init, 0);
        System.out.println(bfs(init));

    }

    public static int bfs(String init) {
        Queue<String> q = new ArrayDeque<>();
        q.offer(init);
        while (!q.isEmpty()) {
            String p = q.poll();
            Integer value = map.get(p);
            if (p.equals(res)) {
                return value;
            }
            int idx = p.indexOf('0');
            int nx = idx / 3;
            int ny = idx % 3;
            for (int i = 0; i < 4; i++) {
                int px = nx + dx[i];
                int py = ny + dy[i];
                if (px < 0 || py < 0 || px > 2 || py > 2) continue;
                int k = px * 3 + py;
                char ch = p.charAt(k);
                String rp = p.replace(ch, 'c');
                rp = rp.replace('0', ch);
                rp = rp.replace('c', '0');
                if (!map.containsKey(rp)) {
                    q.offer(rp);
                    map.put(rp, value + 1);
                }
            }
        }
        return -1;
    }
}
