
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr = {1, 2, 3};

    static void D(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }
        for (int i = 0; i < arr.length; i++) {
            if (check(str + arr[i])) {
                D(str + arr[i]);
            }
        }
    }

    private static boolean check(String str) {
        int len = str.length() / 2;
        for (int i = 1; i <= len; i++) {
            if (str.substring(str.length() - i).equals(str.substring(str.length() - i * 2, str.length() - i))) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        D("");
    }
}
