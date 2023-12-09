import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    //모음개수는 l - 2개까지 가능.
    static int l, c;
    static String[] arr, make;
    static int[] ch;
    static List<String> moum = new LinkedList<>();
    static List<String> res = new LinkedList<>();

    public static void D(int L, int start) {
        if (L == l) {
            int cnt = 0;
            for (int i = 0; i < make.length; i++) {
                if (moum.contains(make[i])) cnt++;
                if (cnt > l - 2) return;
            }
            if (cnt >= 1) {
                String[] colon = make.clone();
                Arrays.sort(colon);

                StringBuilder sb = new StringBuilder();
                for (String x : colon) {
                    sb.append(x);
                }
                res.add(sb.toString());
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    make[L] = arr[i];
                    D(L + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] z = br.readLine().split(" ");
        l = Integer.parseInt(z[0]);
        c = Integer.parseInt(z[1]);
        arr = new String[c];
        ch = new int[c];
        make = new String[l];
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
            System.out.println(x);
        }
    }

}
