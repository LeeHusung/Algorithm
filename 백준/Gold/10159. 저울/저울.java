import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int[] ch = new int[n + 1];
            q.offer(i);
            ch[i] = 1;
            int cnt = 1;
            while (!q.isEmpty()) {
                Integer p = q.poll();
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][0] == p && ch[arr[j][1]] == 0) {
                        q.offer(arr[j][1]);
                        ch[arr[j][1]] = 1;
                        cnt++;
                    }
                }
            }
            q.offer(i);
            while (!q.isEmpty()) {
                Integer p = q.poll();
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][1] == p && ch[arr[j][0]] == 0) {
                        q.offer(arr[j][0]);
                        ch[arr[j][0]] = 1;
                        cnt++;
                    }
                }
            }
            sb.append(n - cnt).append("\n");
        }
        System.out.println(sb);
    }
}
