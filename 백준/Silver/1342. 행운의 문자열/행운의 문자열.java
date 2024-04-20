import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n, ans;
    static int[] ch;
    static char[] arr, res;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        arr = input.toCharArray();
        ans = 0;
        res = new char[arr.length];
        ch = new int[arr.length];
        n = arr.length;
        D(0);
        System.out.println(set.size());

    }

    private static void D(int L) {
        if (L == n) {
            if (check()) {
                StringBuilder sb = new StringBuilder();
                for (char re : res) {
                    sb.append(re);
                }
                set.add(sb.toString());
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    res[L] = arr[i];
                    D(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] == res[i + 1]) return false;
        }
        return true;
    }
}
