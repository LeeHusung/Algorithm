import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        int L = bfs(a, b);

        System.out.println(L);
    }

    private static int bfs(long a, long b) {
        Queue<Long> q = new LinkedList<>();
        q.offer(a);
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                long p = q.poll();
                if (p == b) {
                    return L;
                }
                if (p > b) continue;
                long n1 = p * 2;
                long n2 = p * 10 + 1;
                q.offer(n1);
                q.offer(n2);
            }
        }
        return -1;
    }
}
