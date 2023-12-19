import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int A, B, answer;
    static int[] arr, res, ch;

    private static void D(int L) {
        if (L == arr.length) {
            String s = "";
            for (int x : res) {
                s += x;
            }
            if (s.charAt(0) == '0') return;
            if (Integer.parseInt(s) < B) {
//                System.out.println(s.toString());
                answer = Math.max(answer, Integer.parseInt(s));
                return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                res[L] = arr[i];
                D(L + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        answer = Integer.MIN_VALUE;
        String strA = String.valueOf(A);
        arr = new int[strA.length()];
        ch = new int[strA.length()];
        res = new int[strA.length()];
        for (int i = 0; i < strA.length(); i++) {
            arr[i] = strA.charAt(i) - '0';
        }

        D(0);
        if (answer == Integer.MIN_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

}
