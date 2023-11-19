import java.util.*;

public class Main {

    static int n, m;
    static LinkedList<Integer> list = new LinkedList<>();
    static LinkedList<Integer> res = new LinkedList<>();
    public static void D(int L) {
        if (L == m) {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println();

        } else {
            for (int i = 0; i < list.size(); i++) {
                if (!res.isEmpty() && res.peekLast() > list.get(i)) continue;
                res.add(list.get(i));
                D(L + 1);
                res.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (list.contains(x)) continue;
            list.add(x);
        }
        Collections.sort(list);

        D(0);

    }
}
