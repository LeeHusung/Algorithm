import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[5000001];
        for (int j = 0; j < n; j++) {
            int s = sc.nextInt();
            int i = sc.nextInt();
            int c = sc.nextInt();
            for (int k = 0; k < c; k++) {
                arr[s] = 1;
                s+=i;
            }
        }

        int answer = -1;
        for (int i = t; i < arr.length; i++) {
            if (arr[i] == 1) {
                answer = i - t;
                break;
            }
        }
        System.out.println(answer);
    }
}