import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[] ch = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            String[] s1 = br.readLine().split(" ");
            map.put(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        ch[1] = 1;
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer p = q.poll();
                if (p > 100) continue;
                if (p == 100) {
                    System.out.println(L - 1);
                    return;
                }
                for (int j = 1; j <= 6; j++) {
                    int np = p + j;
                    if (np > 100) continue;
                    if (ch[np] == 1) continue;
                    if (ch[np] == 0) {
                        ch[np] = 1;
                        if (map.containsKey(np)) {
                            q.offer(map.get(np));
                        } else q.offer(np);
                    }
                }
            }
        }
    }
}
