import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        char key;
        long value;

        public Point(char key, long value) {
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Long> map = new HashMap<>();
        Map<Character, Long> res = new HashMap<>();
        Set<Character> noFirst = new HashSet<>();
        List<String> list = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            noFirst.add(s.charAt(0));
            list.add(s);
            long x = 1;
            for (int j = s.length()-1; j >=0; j--) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0L) + x);
                x *= 10;
            }
        }
        for (Character x : map.keySet()) {
            points.add(new Point(x, map.get(x)));
        }
        Collections.sort(points, (a, b) -> Long.compare(b.value, a.value));

        List<Character> possible = new ArrayList<>();

        if (map.size() == 10) {
            for (char ch = 'A'; ch <= 'J'; ch++) {
                if (!noFirst.contains(ch)) {
                    possible.add(ch);
                }
            }
            long num = 9;

            char zero = 0;
            for (int i = points.size()-1; i >= 0; i--) {
                if (possible.contains(points.get(i).key)) {
                    res.put(points.get(i).key, 0L);
                    zero = points.get(i).key;
                    break;
                }
            }
            for (Point point : points) {
                if (point.key == zero) continue;
                res.put(point.key, num--);
            }
        } else {
            long num = 9;
            for (Point point : points) {
                res.put(point.key, num--);
            }
        }
        long answer = 0;
        for (String s : list) {
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                str += res.get(s.charAt(i));
            }
            answer += Long.parseLong(str);
        }
        System.out.println(answer);


    }
}
