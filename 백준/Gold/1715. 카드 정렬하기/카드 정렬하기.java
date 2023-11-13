import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        int answer = 0;
        while (pq.size() != 1) {
            int a = pq.poll();
            int  b = pq.poll();
            int cnt = a + b;
            answer += cnt;
            pq.offer(cnt);
        }
        System.out.println(answer);
    }
}
