import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr, ch;
    static LinkedList<Integer> list = new LinkedList<>();
    static LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    public static void D(int L) {
        if (L == m) {
            if (!res.contains(list)) res.add(new LinkedList<>(list));

        } else {
            int pre = -1;
            for (int i = 0; i < arr.length; i++) {
                if (!list.isEmpty() && list.peekLast() > arr[i]) continue;
                if (pre != arr[i]) {
                    list.add(arr[i]);
                    D(L + 1);
                    list.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        D(0);

        for (int i = 0; i < res.size(); i++) {
            LinkedList<Integer> ans = res.get(i);
            for (int j = 0; j < ans.size(); j++) {
                System.out.print(ans.get(j) + " ");
            }
            System.out.println();
        }
    }
}
