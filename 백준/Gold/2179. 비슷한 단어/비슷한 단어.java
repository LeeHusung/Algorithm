import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        String[] clone = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        clone = arr.clone();

        Arrays.sort(clone);
//        for (String s : arr) {
//            System.out.print(s + " ");;
//        }

        List<String> size = new ArrayList<>();
        String max = "";
        for (int i = 1; i < arr.length; i++) {
            String pre = clone[i - 1];
            String cur = clone[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < Math.min(pre.length(), cur.length()); j++) {
                if (pre.charAt(j) == cur.charAt(j)) {
                    sb.append(pre.charAt(j));
                } else {
                    break;
                }
            }
            if (sb.length() >= max.length()) {
                max = sb.toString();
                size.add(sb.toString());
            }
        }

        List<String> tmp = new ArrayList<>();
        for (String s : size) {
            if (s.length() == max.length()) {
                tmp.add(s);
            }
        }
//        for (String s : tmp) {
//            System.out.println(s);
//        }

        for (String s : arr) {
            boolean flag = false;
            for (String string : tmp) {
                if (s.contains(string)) {
                    max = string;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

//        System.out.println(max);
        if (max.isEmpty()) {
            System.out.println("");
            return;
        }

        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s.startsWith(max) && !list.contains(s)) {
                list.add(s);
                if (list.size() == 2) break;
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
