import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> list = new ArrayList<>();
        int start = 0;
        int end = start + x - 1;
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        list.add(sum);
        while (end < n) {
            end++;
            if (end >= n) break;
            sum += arr[end];
            sum -= arr[start];
            start++;
            list.add(sum);
        }

        Collections.sort(list);
        long k = list.get(list.size() - 1);
        if (k == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(k);
        int cnt = 0;
        for (Long l : list) {
            if (l == k) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
