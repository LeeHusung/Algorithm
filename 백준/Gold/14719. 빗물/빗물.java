import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int H = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);
        int[][] arr = new int[H][W];

        String[] s1 = br.readLine().split(" ");
        for (int j = 0; j < W; j++) {
            int x = Integer.parseInt(s1[j]);
            for (int i = H - 1; i >= H - x; i--) {
                arr[i][j] = 1;
            }
        }

        int answer = 0;
        for (int i = H - 1; i >= 0; i--) {
            int start = 0;
            boolean flag = false;
            for (int j = 0; j < W; j++) {
                if (flag && arr[i][j] == 1) {
                    answer += j - start - 1;
                    start = j;
                    continue;
                }
                if (arr[i][j] == 1) {
                    flag = true;
                    start = j;
                }
//                System.out.println(start);
            }
        }
        System.out.println(answer);

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
