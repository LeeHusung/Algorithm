import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        int[][] arr = new int[101][101];

        for (int i = 1; i <= 3; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(s1[j - 1]);
            }
        }
        int rlen = 3;
        int clen = 3;

        int answer = -1;
        int time = 0;
        while (time <= 100) {
            if (rlen >= r || clen >= c) {  // 조건 수정
                if (arr[r][c] == k) {
                    System.out.println(time);
                    return;
                }
            }
            time++;

            if (rlen >= clen) {
                for (int i = 1; i <= rlen; i++) {
                    int[] cnt = new int[101];
                    for (int j = 1; j <= clen; j++) {
                        cnt[arr[i][j]]++;
                        arr[i][j] = 0;
                    }
                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
                    for (int j = 1; j < 101; j++) {
                        if (cnt[j] != 0) {
                            pq.offer(new int[]{j, cnt[j]});
                        }
                    }
                    int idx = 1;
                    while (!pq.isEmpty() && idx <= 100) {
                        int[] p = pq.poll();
                        arr[i][idx++] = p[0];
                        if (idx > 100) break;
                        arr[i][idx++] = p[1];
                    }
                    clen = Math.max(clen, idx - 1);
                }

            }
            else {
                for (int i = 1; i <= clen; i++) {
                    int[] cnt = new int[101];
                    for (int j = 1; j <= rlen; j++) {
                        if (arr[j][i] != 0) {
                            cnt[arr[j][i]]++;
                            arr[j][i] = 0;
                        }
                    }
                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
                    for (int j = 1; j < 101; j++) {
                        if (cnt[j] != 0) {
                            pq.offer(new int[]{j, cnt[j]});
                        }
                    }
                    int idx = 1;
                    while (!pq.isEmpty() && idx <= 100) {
                        int[] p = pq.poll();
                        arr[idx++][i] = p[0];
                        if (idx > 100) break;
                        arr[idx++][i] = p[1];
                    }
                    rlen = Math.max(rlen, idx - 1);
                }
            }

        }

        System.out.println(answer);


//        int[][] arr = new int[3][3];
//        for (int i = 0; i < 3; i++) {
//            String[] s1 = br.readLine().split(" ");
//            for (int j = 0; j < 3; j++) {
//                arr[i][j] = Integer.parseInt(s1[j]);
//            }
//        }
//
//        int answer = -1;
//        int time = 0;
//        while (time <= 100) {
//
//            if (arr.length > r && arr[0].length > c && arr[r][c] == k) {
//                System.out.println(time);
//                return;
//            }
//            time++;
//            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
//            int rows = arr.length;
//            int cols = arr[0].length;
//            if (rows >= cols) {
//                int max = 0;
//                for (int i = 0; i < rows; i++) {
//                    int[] row = arr[i];
//                    Set<Integer> set = new HashSet<>();
//                    for (int j = 0; j < row.length; j++) {
//                        set.add(row[j]);
//                    }
//                    max = Math.max(max, set.size());
//                }
//                int[][] tmp = new int[rows][max * 2];
//                for (int i = 0; i < rows; i++) {
//                    Map<Integer, Integer> map = new HashMap<>();
//                    int[] row = arr[i];
//                    for (int j = 0; j < row.length; j++) {
//                        if (row[j] > 0) {
//                            map.put(row[j], map.getOrDefault(row[j], 0) + 1);
//                        }
//                    }
//                    for (int key : map.keySet()) {
//                        pq.offer(new int[]{key, map.get(key)});
//                    }
//                    int idx = 0;
//                    while (!pq.isEmpty()) {
//                        int[] p = pq.poll();
//                        for (int j = 0; j < p.length; j++) {
//                            tmp[i][idx++] = p[j];
//                        }
//                    }
//                }
//                arr = tmp;
////                for (int i = 0; i < arr.length; i++) {
////                    for (int j = 0; j < arr[i].length; j++) {
////                        System.out.print(arr[i][j] + " ");
////                    }
////                    System.out.println();
////                }
////                return;
//            }
//            else {
//                int max = 0;
//                for (int i = 0; i < cols; i++) {
//                    Set<Integer> set = new HashSet<>();
//                    for (int j = 0; j < rows; j++) {
//                        set.add(arr[j][i]);
//                    }
//                    max = Math.max(max, set.size());
//                }
//                int[][] tmp = new int[max * 2][cols];
//
//                for (int i = 0; i < arr[0].length; i++) {
//                    Map<Integer, Integer> map = new HashMap<>();
//                    for (int j = 0; j < arr.length; j++) {
//                        if (arr[j][i] > 0) {
//                            map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
//                        }
//                    }
//                    for (int key : map.keySet()) {
//                        pq.offer(new int[]{key, map.get(key)});
//                    }
//                    int idx = 0;
//                    while (!pq.isEmpty()) {
//                        int[] p = pq.poll();
//                        for (int j = 0; j < p.length; j++) {
//                            tmp[idx++][i] = p[j];
//                        }
//                    }
//                }
//                arr = tmp;
//
//            }
//
//
//        }
//
//
//        System.out.println(answer);

    }
}
