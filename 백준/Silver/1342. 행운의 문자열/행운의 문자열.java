import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        arr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'a']++;
        }
        ans = 0;
        n = input.length();
        D(0, ' ');
        System.out.println(ans);

    }

    private static void D(int L, char c) {
        if (L == n) {
            ans++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            if (c != (char) (i + 'a')) {
                arr[i]--;
                D(L + 1, (char) (i + 'a'));
                arr[i]++;
            }
        }
    }
}
