import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            sb = new StringBuilder();
            int n = sc.nextInt();
            int k = 1;
            for (int i = 0; i < n; i++) {
                k *= 3;
            }
            for (int i = 0; i < k; i++) {
                sb.append("-");
            }

            int start = 0;
            D(k, start);
            System.out.println(sb);
        }
    }

    private static void D(int k, int start) {
        if (k == 1) return;
        for (int i = start + k / 3; i < start + k / 3 * 2; i++) {
            sb.setCharAt(i, ' ');
        }
        D(k / 3, start);
        D(k / 3, start + k / 3 * 2);
    }
}