import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static List<Integer> alist = new ArrayList<>();
    static List<Integer> blist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            alist.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            blist.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = alist.get(i);
            for (int j = 0; j < m; j++) {
                int y = blist.get(j);
                if (x == y) {
                    res.add(x);
                }
            }
        }
        if (res.isEmpty()) {
            System.out.println(0);
            return;
        }
        cnt++;
        Collections.sort(res);
        int max = res.get(res.size() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append(" ");
        while (true) {
            int aidx = alist.indexOf(max);
            List<Integer> subList1 = alist.subList(aidx + 1, alist.size());
            int bidx = blist.indexOf(max);
            List<Integer> subList2 = blist.subList(bidx + 1, blist.size());
            max = getMax(subList1, subList2);
            alist = new ArrayList<>(subList1);
            blist = new ArrayList<>(subList2);
            if (max == 0) break;
            sb.append(max).append(" ");
        }
        System.out.println(cnt);

        System.out.println(sb);

    }

    private static int getMax(final List<Integer> alist, final List<Integer> blist) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < alist.size(); i++) {
            int x = alist.get(i);
            for (int j = 0; j < blist.size(); j++) {
                int y = blist.get(j);
                if (x == y) {
                    res.add(x);
                }
            }
        }
        Collections.sort(res);
        if (res.isEmpty()) return 0;
        cnt++;
        return res.get(res.size() - 1);
    }


}
