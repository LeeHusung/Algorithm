import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static char[] arr;
    static Set<String> set = new HashSet<>();

    private static void D(int left, int right, String x, String path) {
        if (left == 0 && right == arr.length-1) {
            set.add(path);
            return;
        }
        if (left - 1 >= 0) {
            D(left-1, right, arr[left-1] + x, path + " " + arr[left-1] + x);
        }
        if (right + 1 < arr.length) {
            D(left, right + 1, x + arr[right + 1], path + " " + x + arr[right + 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            D(i, i, "" + arr[i], ""+arr[i]);
        }
        System.out.println(set.size());
    }
}
