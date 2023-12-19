import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        LinkedList<Integer> plus = new LinkedList<>();
        LinkedList<Integer> minus = new LinkedList<>();
        boolean zero = false;
        for (int x : arr) {
            if (x == 0) zero = true;
            if (x > 0) plus.add(x);
            else minus.add(x);
        }

        Collections.sort(plus, (a, b) -> b - a);
        Collections.sort(minus);

        int answer = 0;
        while (plus.size() > 1) {
            int x = plus.pollFirst();
            int y = plus.pollFirst();

            if (y == 1) {
                answer += x + y;
                continue;
            }
            answer += x * y;
        }
        while (minus.size() > 1) {
            int x = minus.pollFirst();
            int y = minus.pollFirst();
            answer += x * y;
        }
        if (!minus.isEmpty() && zero) {
            minus.poll();
            zero = false;
        }
        if (!plus.isEmpty() && zero) {
            answer += plus.poll();
        }
        if (!minus.isEmpty() && !zero) {
            answer += minus.poll();
        }
        if (!plus.isEmpty() && !zero) {
            answer += plus.poll();
        }
        System.out.println(answer);
    }
}
