import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sarr = new String[n];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sarr[i] = s;
            int zungyodo = 1;
            for (int j = s.length() - 1; j >= 0; j--) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + zungyodo);
                zungyodo *= 10;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        int num = 9;
        for (char ch : list) {
            map.put(ch, num--);
        }

        // 40퍼? 정도에서 틀림
        //아마 중요도가 같은 알파벳에 문자가 바뀌여서 들어가서 ??
//        List<Integer> list = new LinkedList<>();
//        for (char ch : map.keySet()) {
//            list.add(map.get(ch));
//        }
//        Collections.sort(list, (a, b) -> b - a);
//
//        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int idx = 0;
//        for (int x : list) {
//            for (char ch : map.keySet()) {
//                if (x == map.get(ch)) {
//                    map.put(ch, nums[idx++]);
//                    break;
//                }
//            }
//        }
//
        int answer = 0;
        for (String x : sarr) {
            String str = "";
            for (int i = 0; i < x.length(); i++) {
                str += map.get(x.charAt(i));
            }
            answer += Integer.parseInt(str);
        }
        System.out.println(answer);

    }
}
