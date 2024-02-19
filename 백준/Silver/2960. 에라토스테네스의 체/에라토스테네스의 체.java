import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = 1;
        }
        int cnt = 0;
        int answer = 0;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 1) {
                cnt++;
                if (cnt == k) {
                    answer = i;
                    break;
                }
                for (int j = i + i; j < arr.length; j++) {
                    if (j % i == 0 && arr[j] == 1) {
                        arr[j]--;
                        cnt++;
                        if (cnt == k) {
                            answer = j;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}