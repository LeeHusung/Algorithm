import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void D(int L, String str) {
        //소수판별
        if (!str.equals("")) {
            int cur = Integer.parseInt(str);
            boolean flag = true;
            if (cur < 2) flag = false;
            else if (cur == 2) flag = true;
            else {
                for (int i = 2; i <= Math.sqrt(cur); i++) {
                    if (cur % i == 0) {
                        flag = false;
                    }
                }
            }

            if (!flag) return;
            if (L == n && String.valueOf(Integer.parseInt(str)).length() == n) {
                sb.append(Integer.parseInt(str)).append("\n");
                return;
            }
        }
        for (int i = 0; i <= 9; i++) {
            D(L + 1, str + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n];
        D(0, "");

        System.out.println(sb.toString());
    }
}
