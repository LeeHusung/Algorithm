import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] carr = input.toCharArray();
        Integer[] arr = new Integer[carr.length];
        int idx = 0;
        for (char ch : carr) {
            arr[idx++] = ch - '0';
        }

        Arrays.sort(arr, (a, b) -> b - a);

        String str = "";
        for (int x : arr) {
            str += x;
        }
        System.out.println(str);
    }
}
