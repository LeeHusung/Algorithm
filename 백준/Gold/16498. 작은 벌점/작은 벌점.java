import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int[] aa = new int[a];
        int[] bb = new int[b];
        int[] cc = new int[c];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < a; i++) {
            aa[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < b; i++) {
            bb[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < c; i++) {
            cc[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aa);
        Arrays.sort(bb);
        Arrays.sort(cc);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < aa.length; i++) {
            int num1 = binary(aa[i], bb);
            int num2 = binary(aa[i], cc);
            min = Math.min(min, Math.abs(Math.max(aa[i], Math.max(num2, num1)) - Math.min(aa[i], Math.min(num2, num1))));
        }
        for (int i = 0; i < bb.length; i++) {
            int num1 = binary(bb[i], aa);
            int num2 = binary(bb[i], cc);
            min = Math.min(min, Math.abs(Math.max(bb[i], Math.max(num2, num1)) - Math.min(bb[i], Math.min(num2, num1))));
        }
        for (int i = 0; i < cc.length; i++) {
            int num1 = binary(cc[i], bb);
            int num2 = binary(cc[i], aa);
            min = Math.min(min, Math.abs(Math.max(cc[i], Math.max(num2, num1)) - Math.min(cc[i], Math.min(num2, num1))));
        }
        System.out.println(min);
    }

    private static int binary(int num, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int tmp = 0;
        int max = Integer.MAX_VALUE;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (Math.abs(num - arr[middle]) < max) {
                max = Math.abs(num - arr[middle]);
                tmp = arr[middle];
            }
            if (arr[middle] > num) {
                end = middle - 1;
            } else start = middle + 1;
        }
        return tmp;
    }
}
