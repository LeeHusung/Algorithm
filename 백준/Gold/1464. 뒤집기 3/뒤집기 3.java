import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder s = new StringBuilder(str.substring(0, 1));

        for (int i = 1; i < str.length(); i++) {
            if (s.charAt(i-1) < str.charAt(i)) {
                s.insert(0, str.charAt(i));
            } else {
                s.append(str.charAt(i));
            }
        }

        System.out.println(s.reverse().toString());

    }
}
