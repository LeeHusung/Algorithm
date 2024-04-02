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
        long[] cnt = new long[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int dead = Integer.parseInt(st.nextToken());
            int cupramen = Integer.parseInt(st.nextToken());
            arr[i][0] = dead;
            arr[i][1] = cupramen;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i][1]);
            if (pq.size() > arr[i][0]) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);

    }
}
