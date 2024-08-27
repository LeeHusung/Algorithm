import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();
        if (a.equals(b)) {
            System.out.println(0);
            return;
        }
        char[] aarr = a.toCharArray();
        char[] barr = b.toCharArray();
        char[] copy = aarr.clone();
        aarr[0] = (aarr[0] == '1') ? '0' : '1';
        aarr[1] = (aarr[1] == '1') ? '0' : '1';


        int cnt1 = 1;
        for (int i = 1; i < n; i++) {
            if (aarr[i - 1] != barr[i - 1]) {
                cnt1++;
                aarr[i - 1] = (aarr[i - 1] == '1') ? '0' : '1';
                aarr[i] = (aarr[i] == '1') ? '0' : '1';
                if (i + 1 < n) aarr[i + 1] = (aarr[i + 1] == '1') ? '0' : '1';
            }
        }

        boolean flag1 = true;
        for (int i = 0; i < aarr.length; i++) {
            if (aarr[i] != barr[i]) {
                flag1 = false;
            }
        }
        boolean flag2 = true;

        int cnt2 = 0;
        for (int i = 1; i < n; i++) {
            if (copy[i - 1] != barr[i - 1]) {
                cnt2++;
                copy[i - 1] = (copy[i - 1] == '1') ? '0' : '1';
                copy[i] = (copy[i] == '1') ? '0' : '1';
                if (i + 1 < n) copy[i + 1] = (copy[i + 1] == '1') ? '0' : '1';
            }
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != barr[i]) {
                flag2 = false;
            }
        }
        int max = Integer.MAX_VALUE;
        if (flag1) {
            max = Math.min(max, cnt1);
        }
        if (flag2) {
            max = Math.min(max, cnt2);
        }
        if (max == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }
}
