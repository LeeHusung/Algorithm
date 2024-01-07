import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] oper = {" ", "+", "-"};
    static int[] arr;
    static int n;

    public static void D(int L, String str) {
        if (L == n-1) {
            String s = str.replaceAll(" ", "");
            String[] split = s.split("\\+|-");
            int sum = Integer.parseInt(split[0]);
            int idx = split[0].length();
            for (int i = 1; i < split.length; i++) {
                if (s.charAt(idx) == '+'){
                    sum += Integer.parseInt(split[i]);
                } else {
                    sum -= Integer.parseInt(split[i]);
                }
                idx += split[i].length() + 1;
            }
            if (sum == 0) System.out.println(str);
            return;
        }
        for (int i = 0; i < oper.length; i++) {
            D(L + 1, str + oper[i] + (L+2));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for (int j = 1; j <= n; j++) {
                arr[j - 1] = j;
            }

            D(0, "1");
            System.out.println();
        }

    }
}
