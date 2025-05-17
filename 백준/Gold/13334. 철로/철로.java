import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            if (h > o) {
                arr[i][0] = o;
                arr[i][1] = h;
                continue;
            }
            arr[i][0] = h;
            arr[i][1] = o;
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);


        int d = Integer.parseInt(br.readLine());

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int[] x : arr) {
            if (x[1] - x[0] > d) continue;
            while (!pq.isEmpty() && pq.peek() < x[1] - d) {
                pq.poll();
                cnt--;
            }
            pq.offer(x[0]);
            cnt++;
            answer = Math.max(answer, cnt);
        }
//        for (int[] x : pq) {
//            System.out.println(Arrays.toString(x));
//        }
        System.out.println(answer);

    }
}
