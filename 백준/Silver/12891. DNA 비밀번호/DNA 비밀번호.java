import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] carr = {'A', 'C', 'G', 'T'};

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ch = new int[4];
        for (int i = 0; i < p; i++) {
            ch[add(str.charAt(i))]++;
        }
        int answer = 0;
        if (isValid(ch)) {
            answer++;
        }
        for (int i = p; i < s; i++) {
            ch[add(str.charAt(i))]++;
            ch[add(str.charAt(i-p))]--;
            if (isValid(ch)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isValid(int[] ch) {
        for (int i = 0; i < 4; i++) {
            if (arr[i] > ch[i]) return false;
        }
        return true;
    }

    private static int add(char x) {
        switch (x) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }
}
