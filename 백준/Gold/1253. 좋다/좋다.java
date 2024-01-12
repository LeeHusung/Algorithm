import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int k = 0; k < arr.length; k++) {
            int x = arr[k];
            int i = 0, j = n - 1;
            while (i < j) {
                if (i == k) {
                    i++;
                    continue;
                }
                if (j == k) {
                    j--;
                    continue;
                }
                if (arr[i] + arr[j] == x) {
                    answer++;
                    break;
                } else {
                    if (arr[i] + arr[j] > x) j--;
                    else i++;
                }
            }
        }
        System.out.println(answer);


    }
}
