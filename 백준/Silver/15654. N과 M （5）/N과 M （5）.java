import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void D(int L) {
        if (L == m) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!list.isEmpty() && list.contains(arr[i])) continue;
                list.add(arr[i]);
                D(L + 1);
                list.pollLast();
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        D(0);
    }
}
