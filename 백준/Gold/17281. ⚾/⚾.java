import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int n, answer, out;
    static int[][] arr;
    static int[] hitters;
    static int[] ch;
    static int[] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][10];
        out = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        hitters = new int[10];
        ch = new int[10];
        hitters[4] = 1;
        ch[4] = 1;
        base = new int[4];
        answer = 0;

        D(2);

        System.out.println(answer);
    }

    private static void D(int L) {
        if (L == 10) {
            int result = play();
            answer = Math.max(answer, result);
        } else {
            for (int i = 1; i < 10; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    hitters[i] = L;
                    D(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    private static int play() {
        int idx = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            boolean[] base = new boolean[4];
            out = 0;
            int inningScore = 0;
            while (out < 3) {
                switch (arr[i][hitters[idx]]) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        if (base[3]){
                            inningScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[2] = true;
                            base[1] = false;
                        }
                        base[1] = true;
                        break;
                    case 2:
                        if (base[3]){
                            inningScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    case 3:
                        if (base[3]){
                            inningScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    case 4:
                        if (base[3]){
                            inningScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        inningScore++;
                        break;
                }
                idx++;
                if (idx >= 10) {
                    idx = 1;
                }
            }
            sum += inningScore;

        }
        return sum;
    }
}