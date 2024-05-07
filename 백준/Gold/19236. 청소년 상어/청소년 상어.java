import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int[][][] arr;
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[4][4][2];
        answer = 0;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
        }

        int sum = arr[0][0][0];
        arr[0][0][0] = -1;
        answer = sum;
        D(arr, sum);
        System.out.println(answer);

    }

    private static void D(int[][][] arr, int sum) {
        answer = Math.max(answer, sum);
        int[][][] copy = moveFish(arr);

        int sharkX = 0, sharkY = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (copy[i][j][0] == -1) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        int dir = copy[sharkX][sharkY][1];
        int preX = sharkX, preY = sharkY;
        for (int i = 0; i < 3; i++) {
            int[][][] newArr = new int[4][4][2];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    newArr[j][k] = copy[j][k].clone();
                }
            }

            sharkX += dx[dir];
            sharkY += dy[dir];
            if (sharkX >= 4 || sharkY >= 4 || sharkX < 0 || sharkY < 0) break;
            if (newArr[sharkX][sharkY][0] > 0) {
                newArr[preX][preY][0] = 0;
                newArr[preX][preY][1] = 0;
                int temp = newArr[sharkX][sharkY][0];
                newArr[sharkX][sharkY][0] = -1;
                D(newArr, sum + temp);
            }
        }

    }

    private static int[][][] moveFish(int[][][] arr) {
        HashSet<Integer> set = new HashSet<>();
        int[][][] copy = new int[4][4][2];
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy[i][j][0] = arr[i][j][0];
                copy[i][j][1] = arr[i][j][1];
                if (copy[i][j][0] > 0) cnt++;
            }
        }

        int dir = 0;
        while (cnt-- > 0) {
            int min = Integer.MAX_VALUE;
            int x = 0, y = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (copy[i][j][0] > 0 && copy[i][j][0] < min && !set.contains(copy[i][j][0])) {
                        min = copy[i][j][0];
                        x = i;
                        y = j;
                        dir = copy[i][j][1];
                    }
                }
            }
            set.add(min);
            int nx = 0, ny = 0;
            while (true) {
                nx = x + dx[dir];
                ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || copy[nx][ny][0] == -1) dir++;
                else {
                    break;
                }
                if (dir > 8) dir = 1;
            }
            int temp1 = copy[x][y][0];
            int temp2 = dir;
            copy[x][y][0] = copy[nx][ny][0];
            copy[x][y][1] = copy[nx][ny][1];
            copy[nx][ny][0] =temp1;
            copy[nx][ny][1] =temp2;
        }
        return copy;
    }

}
