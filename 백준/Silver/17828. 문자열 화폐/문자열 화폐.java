import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] carr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        if (m > n * 26 || m < n) {
            System.out.println("!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (m <= n * 26) {
            m--;
            n--;
            if (m > n * 26) break;
            sb.append("A");
        }
        m++; n++;

        int k = m / 26;
        for (int i = 0; i < k; i++) {
            m -= 26;
        }
        if (m != 0) sb.append(carr[m - 1]);
        for (int i = 0; i < k; i++) {
            sb.append("Z");
        }
//        System.out.println(m + " " + n);

        System.out.println(sb);


    }
}
