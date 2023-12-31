import java.io.*;

public class Main {
    //3, 6, 12, 24, 48, 96, ...
    static char[][] arr;
    public static void D(int x, int y, int n) {
        if (n == 3) {
            arr[x][y] = '*';
            arr[x + 1][y - 1] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = '*';
            arr[x + 2][y - 1] = '*';
            arr[x + 2][y] = '*';
            arr[x + 2][y + 1] = '*';
            arr[x + 2][y + 2] = '*';
            return;
        }
        D(x, y, n / 2);
        D(x + n / 2, y - n/2, n / 2);
        D(x + n / 2, y + n/2, n / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[3072][6144];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ' ';
            }
        }
        D(0, n - 1, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
