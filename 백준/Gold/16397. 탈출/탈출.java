import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int t = Integer.parseInt(s[1]);
        int g = Integer.parseInt(s[2]);
        if (n == g) {
            System.out.println(0);
            return;
        }
        int[] ch = new int[100001];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        ch[n] = 1;
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            if (L > t) {
                System.out.println("ANG");
                return;
            }
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer p = q.poll();
                int x = p + 1;
                int y = p * 2;
                if (x < 100000 && ch[x] == 0) {
                    q.offer(x);
                    ch[x] = 1;
                }
                if (x == g) {
                    System.out.println(L);
                    return;
                }
                if (y == 0) continue;
                if (y > 99999) {
                    continue;
                }
                String str = String.valueOf(y);
                int k = str.length();
                int z = 1;
                for (int j = 1; j < k; j++) {
                    z *= 10;
                }
                int l = y - z;
                if (l == g) {
                    System.out.println(L);
                    return;
                }
                if (ch[l] == 0) {
                    q.offer(l);
                    ch[l] = 1;
                }
            }
        }
        System.out.println("ANG");
    }
}
