import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == y) {
                sb.append(0).append("\n");
                continue;
            }
            Queue<Integer> q = new ArrayDeque<>();
            int[] ch = new int[10001];
            q.offer(x);
            ch[x] = 1;
            int L = 0;
            boolean flag = false;
            while (!q.isEmpty()) {
                L++;
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    Integer p = q.poll();
                    if (p == y) {
                        flag = true;
                        break;
                    }
                    int n = (p / 10) * 10;
                    for (int j = 0; j <= 9; j++) {
                        int tmp = n + j;
                        if (tmp >= 1000 && tmp < 10000 && check(tmp) && ch[tmp] == 0) {
                            ch[tmp] = 1;
                            q.offer(tmp);
                        }
                    }
                    n = p / 100 * 100 + p % 10;
                    for (int j = 0; j <= 9; j++) {
                        int tmp = n + (j * 10);
                        if (tmp >= 1000 && tmp < 10000 && check(tmp) && ch[tmp] == 0) {
                            ch[tmp] = 1;
                            q.offer(tmp);
                        }
                    }
                    n = p / 1000 * 1000 + p % 100;
                    for (int j = 0; j <= 9; j++) {
                        int tmp = n + (j * 100);
                        if (tmp >= 1000 && tmp < 10000 && check(tmp) && ch[tmp] == 0) {
                            ch[tmp] = 1;
                            q.offer(tmp);
                        }
                    }
                    n = p / 10000 * 10000 + p % 1000;
                    for (int j = 0; j <= 9; j++) {
                        int tmp = n + (j * 1000);
                        if (tmp >= 1000 && tmp < 10000 && check(tmp) && ch[tmp] == 0) {
                            ch[tmp] = 1;
                            q.offer(tmp);
                        }
                    }
                }
                if (flag) break;
            }
            sb.append(L - 1).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int x) {
        if (x == 2 || x == 3) return true;
        if (x == 1) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
