import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] ch = new int[100001];
        q.offer(new int[]{n, 0});

        int answer = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int pos = p[0];
            answer = p[1];
            if (pos == k) {
                break;
            }
            ch[pos] = 1;
            if (pos * 2 < 100001 && ch[pos * 2] == 0) {
                q.offer(new int[]{pos * 2, answer});
            }
            if (pos < k && pos + 1 < 100001 && ch[pos + 1] == 0) {
                q.offer(new int[]{pos + 1, answer + 1});
            }
            if (pos - 1 >= 0 && ch[pos - 1] == 0) {
                q.offer(new int[]{pos - 1, answer + 1});
            }
        }

        System.out.println(answer);
    }
}
