
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String str = String.valueOf(n);

        int half = str.length() / 2;
        int sum1 = 0;
        for (int i = 0; i < half; i++) {
            sum1 += Integer.parseInt(str.substring(i, i + 1));
        }
        int sum2 = 0;
        for (int i = half; i < str.length(); i++) {
            sum2 += Integer.parseInt(str.substring(i, i + 1));
        }

        if (sum1 == sum2) {
            System.out.println("LUCKY");
        } else System.out.println("READY");

    }
}