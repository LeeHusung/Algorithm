import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String input = br.readLine();
            int k = Integer.parseInt(br.readLine());
            List<Integer> res = new ArrayList<>();
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                map.putIfAbsent((char) (i + 'a'), new ArrayList<>());
            }
            for (int i = 0; i < input.length(); i++) {
                map.get(input.charAt(i)).add(i);
                if (map.get(input.charAt(i)).size() == k) {
                    res.add(map.get(input.charAt(i)).get(map.get(input.charAt(i)).size() - 1)
                            - map.get(input.charAt(i)).get(0));
                    map.get(input.charAt(i)).remove(0);
                }
            }
            if (res.isEmpty()) {
                sb.append(-1).append("\n");
                continue;
            }
            Collections.sort(res);
            sb.append(res.get(0) + 1).append(" ");
            sb.append(res.get(res.size() - 1) + 1).append("\n");

        }
        System.out.println(sb);
    }
}
