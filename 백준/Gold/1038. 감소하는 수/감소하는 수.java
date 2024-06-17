import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static String[] num = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
    static int[] ch;
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n >= 1023) {
            System.out.println(-1);
            return;
        }
        ch = new int[num.length];
        D(0, "");
        Collections.sort(list);

        System.out.println(list.get(n));
    }

    private static void D(int L, String str) {
        if (L >= num.length + 1) return;
        if (str.length() >= 2 && str.charAt(str.length() - 1) > str.charAt(str.length() - 2)) return;
        if (!str.isEmpty()) list.add(Long.parseLong(str));
        for (int i = 0; i < num.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                String oneStr = str;
                D(L + 1, str + num[i]);
                ch[i] = 0;
                str = oneStr;
            }
        }
    }
}
