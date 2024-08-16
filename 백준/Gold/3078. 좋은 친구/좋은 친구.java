import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        Map<Integer, List<Integer>> map = new HashMap<>();
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (map.containsKey(str.length())) {
                for (int j = 0; j < map.get(str.length()).size(); j++) {
                    if (i - map.get(str.length()).get(j) <= k) {
                        cnt += map.get(str.length()).size();
                        break;
                    } else {
                        map.get(str.length()).remove(j--);
                    }
                }
            } else {
                map.put(str.length(), new ArrayList<>());
            }
            map.get(str.length()).add(i);
        }
        System.out.println(cnt);
    }
}
