import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, max;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        max = Integer.MIN_VALUE;
        D(0, 0);
        System.out.println(max);

    }

    private static void D(int L, int cur) {
        if (list.size() == 2) {
            max = Math.max(max, cur);
            return;
        }
        for (int i = 1; i < list.size() - 1; i++) {
            cur += list.get(i - 1) * list.get(i + 1);
            int p = list.remove(i);
            D(L + 1, cur);
            list.add(i, p);
            cur -= list.get(i - 1) * list.get(i + 1);
        }
    }
}
