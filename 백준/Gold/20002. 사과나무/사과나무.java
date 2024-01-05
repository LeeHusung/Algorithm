import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] arr, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        sum = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i + 1][j + 1] = Integer.parseInt(s[j]);
            }
        }

        //누적합
        sum[0][0] = arr[0][0];
        sum[0][1] = arr[0][0] + arr[0][1];
        sum[1][0] = arr[0][0] + arr[1][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + arr[i][j] - sum[i-1][j-1];
            }
        }

        int size = 2;
        int max = Integer.MIN_VALUE;
        while (size <= n) {
            for (int i = size; i <= n; i++) {
                for (int j = size; j <= n; j++) {
                    int k = sum[i][j] - sum[i-size][j] - sum[i][j-size] + sum[i-size][j-size];
                    if (k >= max) {
                        max = k;
                    }
                }
            }
            size++;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] >= max) {
                    max = arr[i][j];
                }
            }
        }

        System.out.println(max);


    }
}
