import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int[] stair = new int[n + 1];
        stair[0] = 0;
        for (int i = 1; i <= n; i++) {
            int m = sc.nextInt();
            stair[i] = m;
        }

        int[] dy = new int[n + 1];
        dy[0] = 0;
        dy[1] = stair[1];
        if (n > 1) {
            dy[2] = stair[1] + stair[2];
        }

        for (int i = 3; i < n + 1; i++) {
            dy[i] = Math.max((dy[i - 2] + stair[i]), (dy[i - 3] + stair[i - 1] + stair[i]));
        }

        System.out.println(dy[n]);

    }
}
