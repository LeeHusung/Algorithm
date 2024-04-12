import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            q.offer(0);
        }
        int answer = 0;
        int weight = 0;
        int idx = 0;
        while (true) {
            answer++;
            weight -= q.poll();
            if (idx < n && weight + arr[idx] <= l) {
                q.offer(arr[idx]);
                weight += arr[idx];
                if (++idx == n) break;
            } else q.offer(0);
        }

        System.out.println(answer + q.size());

    }
}
