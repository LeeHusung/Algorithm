import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder(input);

        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') cnt++;
            sb.append(input.charAt(i));
        }

        int x = 0;
        int y = x + cnt - 1;
        int min = Integer.MAX_VALUE;
        while (y < sb.length()) {
            int k = 0;
            for (int i = x; i <= y; i++) {
                if (sb.charAt(i) == 'b') k++;
            }
            min = Math.min(min, k);
            x++;
            y++;
        }
        System.out.println(min);
    }
}
