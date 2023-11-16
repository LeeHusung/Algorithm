import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int d = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cnt = 0;
        while (true) {
            if (arr[startX][startY] == 0) {
                arr[startX][startY] = 2;
                cnt++;
                continue;
            }
            if (arr[startX + 1][startY] != 0 && arr[startX][startY + 1] != 0 && arr[startX - 1][startY] != 0 && arr[startX][startY - 1] != 0) {
                int k = (d + 2) % 4;
                int nx = startX + dx[k];
                int ny = startY + dy[k];
                if (arr[nx][ny] != 1) {
                    startX = nx;
                    startY = ny;
                    continue;
                } else {
                    break;
                }
            }
            if (arr[startX + 1][startY] == 0 || arr[startX][startY + 1] == 0 || arr[startX - 1][startY] == 0 || arr[startX][startY - 1] == 0) {
                d = (d + 3) % 4;
                int nx = startX + dx[d];
                int ny = startY + dy[d];
                if (arr[nx][ny] == 0) {
                    startX = nx;
                    startY = ny;
                    continue;
                }
            }
        }
        System.out.println(cnt);



    }
}
