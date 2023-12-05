import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<>());
//        }

        int[][] problem = new int[n][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
//            graph.get(Integer.parseInt(s1[0])).add(Integer.parseInt(s1[1]));
//            int x = Integer.parseInt(s1[0]);
//            int y = Integer.parseInt(s1[1]);
//            pq.offer(new int[]{x, y});
            problem[i][0] = Integer.parseInt(s1[0]);
            problem[i][1] = Integer.parseInt(s1[1]);
        }

        Arrays.sort(problem, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int cnt = arr[i];
            int c = 0;
            for (int j = 0; j < problem.length; j++) {
                if (problem[j][0] == i + 1 && c < cnt) {
                    c++;
                    answer += problem[j][1];
//                    System.out.println(answer);
                }
            }

            if (cnt > 1) {
                int t = 1;
                for (int j = 0; j < problem.length - 1; j++) {
                    if (problem[j][0] == i + 1 && t < cnt) {
                        t++;
                        answer += problem[j + 1][1] - problem[j][1];
                    }
                }
            }
        }


//        int idx = 0;
//        int cnt = 1;
//        int pre = 0;
//
//        while (!pq.isEmpty()) {
//            if (arr[idx] == cnt) {
//                cnt = 1;
//                idx++;
//            }
//            if (arr[idx] > cnt) {
//                cnt++;
//                int[] p = pq.poll();
//                if (p[0] == idx) {
//                    answer += p[1];
//                    answer += p[1] - pre;
//                }
//                pre = p[1];
//            }
//        }
//
//        int idx = 1;
//        int cnt = 0;
//        int pre = 0;
//        while (!pq.isEmpty()) {
//            int[] p = pq.poll();
//            answer += p[1] - pre;
//            pre = p[1];
//            if (cnt == arr[idx - 1]) {
//                idx++;
//            }
//            if (p[0] == idx && cnt < arr[idx - 1]) {
//                cnt++;
//                answer += p[1];
//            }
//        }






//
//
//
//        int answer = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int cnt = arr[i];
//            int c = 0;
//            for (int j = 0; j < problem.length; j++) {
//                if (problem[j][0] == i + 1 && c < cnt) {
//                    c++;
//                    answer += problem[j][1];
//                }
//
//            }
//        }
//
////        System.out.println(answer);
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > 1) {
//                int cnt = arr[i];
//                int c = 0;
//                for (int j = 0; j < problem.length - 1; j++) {
//                    if (problem[j][0] == i + 1 && c < cnt) {
//                        c++;
//                        answer += problem[j + 1][1] - problem[j][1];
//                    }
//                }
//            }
//        }

        System.out.println(answer + 240);
    }
}
