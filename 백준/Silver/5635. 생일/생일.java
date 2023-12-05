
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int age = getAge(s[1], s[2], s[3]);
            map.put(s[0], age);

        }

        int max = Integer.MIN_VALUE;
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                System.out.println(key);
            }
        }
        int min = Integer.MAX_VALUE;
        for (String key : map.keySet()) {
            if (map.get(key) < min) {
                min = map.get(key);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) == min) {
                System.out.println(key);
            }
        }

    }

    private static int getAge(String day, String month, String year) {
        int d = Integer.parseInt(day);
        int m = Integer.parseInt(month) * 30;
        int y = Integer.parseInt(year) * 10000;
        return y + m + d;
    }
}
