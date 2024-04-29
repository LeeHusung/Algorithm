import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        D(s, t);
        System.out.println(0);
    }

    private static void D(String s, String t) {
        if (s.equals(t)) {
            System.out.println(1);
            System.exit(0);
        }
        if (t.length() == 0) return;

        if (t.charAt(0) == 'B') {
            D(s, new StringBuilder(t.substring(1)).reverse().toString());
        }
        if (t.charAt(t.length() - 1) == 'A') {
            D(s, t.substring(0, t.length()-1));
        }
    }
}
