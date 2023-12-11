import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        s.append(S);
        t.append(T);
        while (true) {
            if (t.length() == s.length()) {
                if (!t.equals(s)) {
                    System.out.println("0");
                    return;
                }
            }
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
                if (t.toString().equals(S)) {
                    System.out.println("1");
                    return;
                }
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
                if (t.toString().equals(S)) {
                    System.out.println("1");
                    return;
                }
            }
        }

    }
}
