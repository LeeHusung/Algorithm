import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static String[] arr;
    static int[] num, ch;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder res = new StringBuilder();
    static String min;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new String[k];
        num = new int[k + 1];
        ch = new int[11];
        min = "";
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            arr[i] = s[i];
        }

        D(0);
        res.append(min);
        System.out.println(res.toString());
    }

    private static void D(int L) {
        if (L >= 2) {
            if (!check(arr, sb, L)) {
                return;
            }
        }
        if (L == k + 1) {
            if (flag) {
                min = sb.toString();
                return;
            }
            res.append(sb).append("\n");
            flag = true;
            return;
        }
        for (int i = 9; i >= 0; i--) {
            if (ch[i] == 0) {
                ch[i] = 1;
                sb.append(i);
                D(L + 1);
                sb.deleteCharAt(sb.length() - 1);
                ch[i] = 0;
            }
        }
    }

    private static boolean check(String[] arr, StringBuilder sb, int L) {
        String s = arr[L - 2];
        if (s.equals("<")) {
            if (sb.charAt(L - 2) > sb.charAt(L - 1)) return false;
        }
        if (s.equals(">")) {
            if (sb.charAt(L - 2) < sb.charAt(L - 1)) return false;
        }
        return true;
    }
}
