import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int answer = 0;
        int[][] ch = new int[2002][2002];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
//        ch[1][0] = 1;
        int L = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
//                if (ch[p[0]][p[1]] == 1) continue;
                if (p[0] == s) {
                    answer = L;
                    flag = true;
                    break;
                }
//                if (ch[p[0]][p[0]] == 1) continue;
//                if (ch[p[0] + p[1]][p[1]] == 1) continue;
//                if (p[0] > 0 && ch[p[0] - 1][p[1]] == 1) continue;
                if (ch[p[0]][p[0]] == 0) {
                    q.offer(new int[]{p[0], p[0]});
                    ch[p[0]][p[0]] = 1;
                }
                if (p[0] + p[1] < 2000 && ch[p[0] + p[1]][p[1]] == 0) {
                    q.offer(new int[]{p[0] + p[1], p[1]});
                    ch[p[0] + p[1]][p[1]] = 1;
                }
                if (p[0] > 0 && ch[p[0] - 1][p[1]] == 0) {
                    q.offer(new int[]{p[0] - 1, p[1]});
                    ch[p[0] - 1][p[1]] = 1;
                }

            }
            if (flag) break;
        }
        System.out.println(L - 1);

    }

}
