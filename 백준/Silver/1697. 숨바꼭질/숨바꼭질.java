import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n > k) {
            System.out.println(n - k);
            return;
        }

//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Queue<Integer> q = new LinkedList<>();
        int[] ch = new int[200001];
//        pq.offer(new int[]{n, 0});
        q.offer(n);
        ch[n] = 1;
        while (!q.isEmpty()) {
            int p = q.poll();
            if (p == k) {
                System.out.println(ch[p] - 1);
                return;
            }
            int plus = p + 1;
            int minus = p - 1;
            int x = p * 2;
            if (x <= k * 2 && ch[x] == 0) {
                q.offer(x);
                ch[x] = ch[p] + 1;
            }
            if (minus >= 0 && ch[minus] == 0) {
                q.offer(minus);
                ch[minus] = ch[p] + 1;
            }
            if (plus <= k * 2 && ch[plus] == 0) {
                q.offer(plus);
                ch[plus] = ch[p] + 1;
            }
        }


    }
}
