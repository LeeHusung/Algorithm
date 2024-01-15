
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                String command = s[0];
                int num = Integer.parseInt(s[1]);

                switch (command) {
                    case "I":
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (map.isEmpty()) break;
                        if (num == -1) {
                            int minKey = map.firstKey();
                            if (map.get(minKey) == 1) {
                                map.remove(minKey);
                            } else {
                                map.put(minKey, map.get(minKey) - 1);
                            }
                        } else {
                            int lastKey = map.lastKey();
                            if (map.get(lastKey) == 1) {
                                map.remove(lastKey);
                            } else {
                                map.put(lastKey, map.get(lastKey) - 1);
                            }
                        }
                        break;
                }
            }
            if (map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }

    }
}
