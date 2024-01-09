import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n + 1];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(s1[i]);
        }

        //부분합
        int[] sum = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        long answer = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] == k) answer++;
            long x = sum[i];
            if (map.containsKey(x - k)) answer += map.get(x - k);
            map.put(x, map.getOrDefault(x, 0L) + 1);
        }
        System.out.println(answer);

    }
}
