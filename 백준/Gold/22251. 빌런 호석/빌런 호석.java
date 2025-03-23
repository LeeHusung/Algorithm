import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String zero = "1110111";
    static String one = "0010010";
    static String two = "1011101";
    static String three = "1011011";
    static String four = "0111010";
    static String five = "1101011";
    static String six = "1101111";
    static String seven = "1010010";
    static String eight = "1111111";
    static String nine = "1111011";
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int p = Integer.parseInt(s[2]);
        int x = Integer.parseInt(s[3]);


        int cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += 7;
        }

        StringBuilder sb = new StringBuilder();
        String strX = String.format("%0" + k + "d", x);
        for (char c : strX.toCharArray()) {
            sb.append(getString(c - '0'));
        }


//        System.out.println("sb : " + sb);
        for (int i = 1; i <= n; i++) {
            String str = String.format("%0" + k + "d", i);
            StringBuilder tmp = new StringBuilder();
            for (char c : str.toCharArray()) {
                tmp.append(getString(c - '0'));
            }
            if (i != x) {
                compare(sb, tmp, p);
            }
        }

        System.out.println(answer);
    }

    private static void compare(StringBuilder sb, StringBuilder tmp, int p) {
//        System.out.println(tmp);
        int k = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != tmp.charAt(i)) {
                k++;
                if (k > p) return;
            }
        }
        if (k > 0 && k <= p) answer++;
    }

    private static String getString(int n) {
        if (n == 0) return zero;
        else if (n == 1) return one;
        else if (n == 2) return two;
        else if (n == 3) return three;
        else if (n == 4) return four;
        else if (n == 5) return five;
        else if (n == 6) return six;
        else if (n == 7) return seven;
        else if (n == 8) return eight;
        else if (n == 9) return nine;
        else return null;
    }

}
