import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            boolean flag = false;
            for (int k = 1; k <= str.length(); k++) {
                String subStr = str.substring(0, k);
                if (!set.contains(subStr)) {
                    set.add(subStr);
                    sb.append(subStr).append("\n");
                    flag = true;
                    break;
                }
            }
            for (int j = 1; j <= str.length(); j++) {
                String subStr = str.substring(0, j);
                set.add(subStr);
            }
            if (!flag) {
                Integer getMap = map.getOrDefault(str, 0);
                if (getMap > 1) {
                    sb.append(str).append(getMap).append("\n");
                } else if (getMap == 1) {
                    sb.append(str).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
