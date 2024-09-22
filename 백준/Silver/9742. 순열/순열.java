import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String x;
    static int num, cnt;
    static StringBuilder sb = new StringBuilder();
    static char[] tmp;
    static int[] ch;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            x = st.nextToken();
            num = Integer.parseInt(st.nextToken());
            cnt = 0;
            str = "";
            tmp = new char[x.length()];
            ch = new int[x.length()];
            D(0);
            if (cnt < num) {
                str = "No permutation";
            }
            System.out.println(x + " " + num  + " = " + str);
        }
    }

    private static void D(int L) {
        if (L == x.length()) {
            cnt++;
            if (cnt == num) {
                str = new String(tmp);
            }
            return;
        }
        for (int i = 0; i < x.length(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                tmp[L] = x.charAt(i);
                D(L + 1);
                ch[i] = 0;
                tmp[L] = '0';
            }
        }
    }
}
