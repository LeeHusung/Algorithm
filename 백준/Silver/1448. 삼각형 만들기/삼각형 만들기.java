import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //삼각형의 조건 : 가장 큰 변의 길이가 나머지 두 변의 길이의 합보다 작아야 가능

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = -1;
        for (int i = n-1; i >= 2; i--) {
            Integer longest = arr[i];
            Integer nextLong = arr[i - 1];
            Integer nextNextLong = arr[i - 2];
            if (longest >= nextLong + nextNextLong) continue;
            else {
                answer = nextLong + nextNextLong + longest;
                break;
            }
        }

        System.out.println(answer);
    }
}
