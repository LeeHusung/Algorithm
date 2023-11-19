import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr, ch;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void D(int L, int start) {
        if (L == m) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    list.add(i);
                    D(L + 1, i + 1);
                    ch[i] = 0;
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
        ch = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        D(0, 1);
    }
}
