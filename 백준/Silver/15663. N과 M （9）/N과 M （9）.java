import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, ch;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void D(int L) {
        if (L == m) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        } else {
            int pre = -1;
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0 && pre != arr[i]) {
                    pre = arr[i];
                    ch[i] = 1;
                    list.add(arr[i]);
                    D(L + 1);
                    list.removeLast();
                    ch[i] = 0;
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
    }
}
