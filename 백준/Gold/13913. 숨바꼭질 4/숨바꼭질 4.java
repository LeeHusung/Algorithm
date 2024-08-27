import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int[] path = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] ch = new int[100001];
        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        path[n] = -1;
        ch[n] = 1;
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer p = q.poll();
                if (p == k) {
                    System.out.println(L - 1);
                    StringBuilder sb = new StringBuilder();
                    Stack<Integer> st = new Stack<>();
                    for (int j = p; j != -1; j = path[j]) {
                        st.push(j);
                    }
                    while (!st.isEmpty()) {
                        sb.append(st.pop()).append(" ");
                    }
                    System.out.println(sb);
                    return;
                }
                if (p + 1 < 100001 && ch[p + 1] == 0) {
                    ch[p + 1] = 1;
                    path[p + 1] = p;
                    q.offer(p + 1);
                }
                if (p - 1 >= 0 && ch[p - 1] == 0) {
                    ch[p - 1] = 1;
                    path[p - 1] = p;
                    q.offer(p - 1);
                }
                if (p * 2 < 100001 && ch[p * 2] == 0) {
                    ch[p * 2] = 1;
                    path[p * 2] = p;
                    q.offer(p * 2);
                }
            }
        }
    }
}
