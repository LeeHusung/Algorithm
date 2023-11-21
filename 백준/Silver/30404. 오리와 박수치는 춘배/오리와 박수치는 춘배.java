import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 1;
        int end = arr[0] + k;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > end) {
                cnt++;
                end = arr[i] + k;
            }
        }

        System.out.println(cnt);
    }
}
