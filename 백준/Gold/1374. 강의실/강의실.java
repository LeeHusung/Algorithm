import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            arr[i][2] = Integer.parseInt(s[2]);
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            if (!pq.isEmpty()) {
                Integer p = pq.peek();
                if (arr[i][1] >= p) {
                    pq.poll();
                    pq.offer(arr[i][2]);
                    continue;
                } else {
                    pq.offer(arr[i][2]);
                    continue;
                }
            }
            pq.offer(arr[i][2]);
        }

        System.out.println(pq.size());


    }
}
