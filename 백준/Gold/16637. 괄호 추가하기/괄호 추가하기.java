import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(input.charAt(i));
        }

        D(0, Integer.parseInt(arr[0]));
        System.out.println(max);
    }

    private static void D(int idx, int x) {
        if (idx == n - 1) {
            max = Math.max(max, x);
            return;
        }
        if (idx + 2 < n) {
            D(idx + 2, calculate(x, arr[idx + 1], Integer.parseInt(arr[idx + 2])));
        }
        if (idx + 4 < n) {
            D(idx + 4, calculate(x, arr[idx + 1], calculate(Integer.parseInt(arr[idx + 2]), arr[idx + 3], Integer.parseInt(arr[idx + 4]))));
        }
    }

    private static int calculate(int a, String o, int b) {
        switch (o) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
        }
        return 0;
    }
}
