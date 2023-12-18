import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            arr[i][0] = x;
            arr[i][1] = y;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            if (!pq.isEmpty()) {
                int p = pq.peek();
                if (arr[i][0] < p) {
                    pq.offer(arr[i][1]);
                    continue;
                } else {
                    pq.poll();
                    pq.offer(arr[i][1]);
                    continue;
                }
            }
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());

    //실패 반례
    // 4
    //1 2
    //1 4
    //2 6
    //4 5
//        int start = 0;
//        int finish = 0;
//        int answer = 1;
//
//        while (!pq.isEmpty()) {
//            int[] p = pq.poll();
//            if (p[0] < finish) {
//                answer++;
//                finish = p[1];
//                continue;
//            }
//            start = p[0];
//            finish = p[1];
//        }

    }
}
