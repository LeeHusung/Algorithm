import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, x, y;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        x = n;
        y = m;
        r = Integer.parseInt(s[2]);
        min = Math.min(min, Math.min(n, m));
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //밖에 테두리부터 개수 모두 세고 r의 배수면 어차피 원점이니까 개수 % r하고 나머지 만큼만 회전하기.

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = m - 1;
        while (true) {
            int size = (rowEnd - rowStart + 1) * 2 + (colEnd - colStart + 1) * 2 - 4;
            rotate(rowStart, rowEnd, colStart, colEnd, r % size);
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotate(int rowStart, int rowEnd, int colStart, int colEnd, int size) {

        for (int i = 0; i < size; i++) {
            int tmp = arr[rowStart][colStart];
            for (int j = colStart; j < colEnd; j++) {
                arr[rowStart][j] = arr[rowStart][j + 1];
            }

            for (int j = rowStart; j < rowEnd; j++) {
                arr[j][colEnd] = arr[j + 1][colEnd];
            }

            for (int j = colEnd; j > colStart; j--) {
                arr[rowEnd][j] = arr[rowEnd][j - 1];
            }

            for (int j = rowEnd; j > rowStart; j--) {
                arr[j][colStart] = arr[j - 1][colStart];
            }
            arr[rowStart + 1][colStart] = tmp;
        }
    }

}
