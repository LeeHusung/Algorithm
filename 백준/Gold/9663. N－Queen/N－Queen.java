import java.util.Scanner;

public class Main {

    static int n, answer;
    static int[] arr;

    public static void D(int L) {
        if (L == n) {
            answer++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                arr[L] = i;
                if (isValid(L)) {
                    D(L + 1);
                }
            }
        }
    }

    public static boolean isValid(int L) {
        for (int i = 0; i < L; i++) {
            if (arr[i] == arr[L] || Math.abs(i - L) == Math.abs(arr[i] - arr[L])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        answer = 0;

        arr = new int[n];

        D(0);

        System.out.println(answer);

    }
}
