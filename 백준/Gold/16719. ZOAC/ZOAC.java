import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static StringBuilder sb = new StringBuilder();
    static int[] ch;
    private static void D(int left, int right) {
        if (left > right) return;
        int min = left;
        for (int i = left; i <= right; i++) {
            if (str.charAt(i) < str.charAt(min)) {
                min = i;
            }
        }
        ch[min] = 1;
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] == 1) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");
        D(min + 1, right);
        D(left, min - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        ch = new int[str.length()];
        D(0, str.length() - 1);
        System.out.println(sb);
    }
}
