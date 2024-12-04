import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] title = new String[n];
        int[] titlePower = new int[n];
//        Map<Integer, String> map = new HashMap<>();
//        Map<Integer, Integer> cnt = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            title[i] = s1[0];
            titlePower[i] = Integer.parseInt(s1[1]);
//            String name = s1[0];
//            int count = Integer.parseInt(s1[1]);
//            if (list.contains(count)) {
//                map.put(i, map.get(i - 1));
//                cnt.put(i, cnt.get(i - 1));
//                continue;
//            }
//            map.put(i, name);
//            cnt.put(i, count);
//            list.add(count);
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int middle = (start + end) / 2;
                int l = titlePower[middle];
                if (k > l) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
//            System.out.println(start + " " + end);
//            System.out.println(map.get(start));
            sb.append(title[start]).append("\n");
        }
        System.out.println(sb);
    }
}
