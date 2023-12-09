import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int n, min, answer;
    static int[][] arr;
    static int[] player, ch;
    public static void D(int L, int start) {
        if (L == n  / 2) {
            int[] a = new int[n / 2];
            int[] b = new int[n / 2];
            int idx = 0;
            int z = 0;

            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 0) {
                    a[idx++] = i;
                } else {
                    b[z++] = i;
                }
            }
            int sumA = 0;
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    sumA += arr[a[i]][a[j]];
                    sumA += arr[a[j]][a[i]];
                }
            }
            int sumB = 0;
            for (int i = 0; i < b.length - 1; i++) {
                for (int j = i + 1; j < b.length; j++) {
                    sumB += arr[b[i]][b[j]];
                    sumB += arr[b[j]][b[i]];
                }
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));
        } else {
            for (int i = start; i < player.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    D(L + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        arr = new int[n][n];
        player = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            player[i] = i;
        }
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        D(0, 0);
        System.out.println(answer);
    }
}
