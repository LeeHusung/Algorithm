import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String x = br.readLine();
                arr[i] = x;
                map.put(x, 0);
            }
            Arrays.sort(arr);
            boolean flag = false;

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < arr[i].length(); j++) {
                    if (map.containsKey(arr[i].substring(0, j))) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");

        }
        System.out.println(sb);

    }
}
