
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int start1 = 0;
        int start2 = 0;

        if (input.charAt(0) == '1') {
            start1++;
        } else {
            start2++;
        }

        for (int i = 0; i < input.length() -1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                if (input.charAt(i + 1) == '1') {
                    start1++;
                } else start2++;
            }
        }


        System.out.println(Math.min(start1, start2));
    }
}
