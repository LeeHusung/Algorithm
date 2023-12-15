import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            int x = Integer.parseInt(s[i]);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(s1[i]);
            if (map.containsKey(x)) {
                sb.append(map.get(x)).append(" ");
            } else sb.append("0").append(" ");
        }

        System.out.println(sb);


    }
}
