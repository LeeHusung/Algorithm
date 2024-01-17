import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l, c;
    static int[] ch;
    static String[] arr;
    static String[] cur;
    static List<String> moum = new ArrayList<>();
    static List<String> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void D(int L, int start) {
        if (L == l) {
            boolean flag = false;
            int mounCnt = 0;
            for (String x : cur) {
                if (moum.contains(x)) {
                    flag = true;
                    mounCnt++;
                }
            }
            if (flag && mounCnt <= l - 2) {
                String[] copy = cur.clone();
                Arrays.sort(copy);
                String x = "";
                for (String s : copy){
                    x += s;
                }
                res.add(x);
            }
        }
        else {
            for (int i = start; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    cur[L] = arr[i];
                    D(L + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        l = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        arr = new String[c];
        cur = new String[l];
        ch = new int[c];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            arr[i] = s1[i];
        }
        moum.add("a");
        moum.add("e");
        moum.add("i");
        moum.add("o");
        moum.add("u");

        D(0, 0);
        Collections.sort(res);
        for (String x : res) {
            sb.append(x).append("\n");
        }

        System.out.println(sb.toString());

    }
}