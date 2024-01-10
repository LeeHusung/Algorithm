
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String L = s[0];
        String R = s[1];

        int cnt = 0;
        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) != R.charAt(i)) break;
                else {
                    if (L.charAt(i) == '8') cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
