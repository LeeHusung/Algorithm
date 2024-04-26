import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (isPrime(n)) {
                sb.append(0).append("\n");
                continue;
            }
            int pre = 0;
            int after = 0;
            for (int i = n; i >= 1; i--) {
                if (isPrime(i)) {
                    pre = i;
                    break;
                }
            }
            for (int i = n; i <= 1299709; i++) {
                if (isPrime(i)) {
                    after = i;
                    break;
                }
            }
            sb.append(after - pre).append("\n");
        }
        System.out.println(sb);

    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
