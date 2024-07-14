import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    static int max;
    static char[] arr;
    static int[] num;
    static LinkedList<Integer> list = new LinkedList<>();
    static Set<String> res = new HashSet<>();
    private static void D(int L, int idx) {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();
        if (L > 0) cal();
        for (int i = idx; i <= max; i++) {
            list.add(i);
            D(L + 1, i + 1);
            list.removeLast();
        }
    }

    private static void cal() {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            x.append(arr[i]);
        }
        res.add(String.valueOf(x));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = new char[str.length()];
        num = new int[str.length()];
        int tmp = 0;
        max = 0;
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(') {
                num[i] = ++tmp;
                max = tmp;
            }
            arr[i] = x;
        }
        int[] ch = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                for (int j = i-1; j >= 0; j--) {
                    if (str.charAt(j) == '(' && ch[j] == 0) {
                        ch[j] = 1;
                        num[i] = num[j];
                        break;
                    }
                }
            }
        }
//        for (int i = 0; i < num.length; i++) {
//            System.out.print(num[i] + " ");
//        }
        D(0, 1);
        List<String> real = new ArrayList<>(res);
        Collections.sort(real);
        for (int i = 0; i < real.size(); i++) {
            System.out.println(real.get(i));
        }

    }
}
