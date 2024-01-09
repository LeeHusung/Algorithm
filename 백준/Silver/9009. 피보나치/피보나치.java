import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Long> fibo = new ArrayList<>();
            int idx = 2;
            fibo.add(0L);
            fibo.add(1L);
            while (true) {
                long x = fibo.get(idx - 1) + fibo.get(idx - 2);
                if (x > n) break;
                fibo.add(x);
                idx++;
            }
            Collections.sort(fibo, Collections.reverseOrder());

            int sum = 0;
            LinkedList<Long> list = new LinkedList<>();
            while (sum != n) {
            for (int i = 0; i < fibo.size(); i++) {
                    if (sum + fibo.get(i) > n) {
                        continue;
                    }
                    list.addFirst(fibo.get(i));
                    sum += fibo.get(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            System.out.println(sb);
        }


    }
}
