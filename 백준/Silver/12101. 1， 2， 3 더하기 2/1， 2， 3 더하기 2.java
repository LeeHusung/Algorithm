import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static LinkedList<Integer> list = new LinkedList<>();
    static List<LinkedList<Integer>> res = new ArrayList<>();
    static int n, cnt;
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        cnt = 0;
        D(0);
        StringBuilder sb = new StringBuilder();
        if (k > res.size()) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < res.get((int)(k - 1)).size(); i++) {
            sb.append(res.get((int) (k - 1)).get(i)).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
        
    }

    private static void D(int L) {
        long sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        if (sum > n) return;
        if (sum == n) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            list.add(i);
            D(L + 1);
            list.pollLast();
        }

        
    }
}
