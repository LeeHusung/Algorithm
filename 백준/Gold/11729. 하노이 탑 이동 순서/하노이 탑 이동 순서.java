import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    private static void D(int tmp, int start, int end) {
        cnt++;
        if (tmp == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        D(tmp - 1, start, 6 - start - end);
        sb.append(start).append(" ").append(end).append("\n");
        D(tmp - 1, 6 - start - end, end);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println("1");
            System.out.println("1 3");
            return;
        }
        D(n, 1, 3);
        System.out.println(cnt);
        System.out.println(sb);

    }
}
