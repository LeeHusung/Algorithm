import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] ch = new int[51];
    static char[] arr;
    static String str;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        arr = str.toCharArray();
        len = str.length();
        D(0, 0, new StringBuilder());
    }


    private static void D(int L, int max, StringBuilder sb) {
        if (L == len) {
            for (int i = 1; i <= max; i++) {
                if (ch[i] == 0) return;
            }
            System.out.println(sb);
            System.exit(0);
        }
        String x = str.substring(L, L + 1);
        int num = Integer.parseInt(x);
        if (ch[num] == 0) {
            ch[num] = 1;
            int pre = sb.length();
            sb.append(arr[L]).append(" ");
            D(L + 1, (num > max) ? num : max,  sb);
            sb.setLength(pre);
            ch[num] = 0;
        }
        if (L < len - 1) {
            String cur = str.substring(L, L + 2);
            num = Integer.parseInt(cur);
            if (num < 51 && ch[num] == 0) {
                ch[num] = 1;
                int pre = sb.length();
                D(L + 2, (num > max) ? num : max, sb.append(num).append(" "));
                sb.setLength(pre);
                ch[num] = 0;
            }
        }
    }
}
