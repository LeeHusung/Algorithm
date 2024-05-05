import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            map.put(x, 0);
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) > 0) {
                map.put(arr[i], map.get(arr[i]) - 1);

            } else cnt++;
            map.put(arr[i] - 1, map.getOrDefault(arr[i] - 1, 0) + 1);
        }

        System.out.println(cnt);

    }

}
