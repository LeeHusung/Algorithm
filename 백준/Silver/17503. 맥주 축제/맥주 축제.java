import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);
        long k = Long.parseLong(s[2]);
        long[][] arr = new long[(int) k][2];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> Math.toIntExact(a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]));

        long min = Long.MIN_VALUE;
        long sum = 0;

//        if (sum < m) {
//            System.out.println(-1);
//            return;
//        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Math.toIntExact(a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int i = 0;
        for (; i < Math.min(n, k); i++) {
            min = Math.max(min, arr[i][1]);
            pq.offer(arr[i]);
            sum += arr[i][0];
        }
//        for (long[] longs : pq) {
//            System.out.println(longs[0] + " " + longs[1]);
//        }
//        System.out.println("==============");

        if (sum >= m) {
            System.out.println(min);
            return;
        }

        List<Long> list = new ArrayList<>();
        while (i < k) {

            if (!pq.isEmpty()) {
                long[] p = pq.poll();
                sum -= p[0];
                sum += arr[i][0];
                pq.offer(arr[i]);
                min = Math.max(min, arr[i][1]);
                i++;
                if (sum >= m) {
                    System.out.println(min);
                    return;
                }
//                for (long[] longs : pq) {
//                    System.out.println(longs[0] + " " + longs[1]);
//                }
//                if (!pq.isEmpty() && sum >= m && pq.size() == n) {
//                    list.add(arr[i][1]);
//                }
            }
        }
        Collections.sort(list);
//        System.out.println("+++++++++++++++++");
//        for (Long l : list) {
//            System.out.print(l + " ");
//        }
//        System.out.println();
//        if (list.isEmpty()) {
            System.out.println(-1);
//        } else System.out.println(list.get(0));
//        System.out.println(min);

    }
}
