import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static int k;
    static int[] arr, ch;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void D(int L, int start) {
        if (L == 6) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < k; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    list.add(arr[i]);
                    D(L + 1, i + 1);
                    ch[i] = 0;
                    list.pollLast();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            String[] split = s.split(" ");
            k = Integer.parseInt(split[0]);
            arr = new int[k];
            ch = new int[k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i + 1]);
            }

            D(0, 0);
            System.out.println();
        }
    }
}
