import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][M];
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                tmp[i][j] = arr[i][j];
            }
        }

        int answer = 0;
        for (int y = 0; y < N; y++) {
            for (int z = 0; z < M; z++) {
                if (z + 3 < M) {
                    int temp =  arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y][z + 3];
                    if (temp > answer) answer = temp;
                }
                if (y + 3 < N) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y + 3][z];
                    if (temp > answer) answer = temp;
                }
                if (z + 1 < M && y + 1 < N) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y][z + 1] + arr[y + 1][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y + 2 < N && z + 1 < M) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y + 2][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y - 2 >= 0 && z + 1 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y - 1][z + 1] + arr[y - 2][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y + 2 < N && z + 1 < M) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y + 2 < N && z + 1 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y + 1][z + 1] + arr[y + 2][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y + 1 < N && z + 2 < M) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y][z + 1] + arr[y][z + 2];
                    if (temp > answer) answer = temp;
                }
                if (y + 1 < N && z + 2 < M) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y + 1][z + 1] + arr[y + 1][z + 2];
                    if (temp > answer) answer = temp;
                }
                if (y + 1 < N && z + 2 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y + 1][z + 2];
                    if (temp > answer) answer = temp;
                }
                if (y - 1 >= 0 && z + 2 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y - 1][z + 2];
                    if (temp > answer) answer = temp;
                }
                if (y + 2 < N && z + 1 < M) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y + 1][z + 1] + arr[y + 2][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y - 1 >= 0 && y + 1 < N && z + 1 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y + 1][z] + arr[y - 1][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y - 1 >= 0 && z + 2 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y - 1][z + 1] + arr[y - 1][z + 2];
                    if (temp > answer) answer = temp;
                }
                if (y + 1 < N && z + 2 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y + 1][z + 1] + arr[y + 1][z + 2];
                    if (temp > answer) answer = temp;
                }
                if (y + 1 < N && z + 2 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y + 1][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y + 1 < N && y - 1 >= 0 && z + 1 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y - 1][z + 1] + arr[y + 1][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y + 2 < N && z + 1 < M) {
                    int temp = arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y + 1][z + 1];
                    if (temp > answer) answer = temp;
                }
                if (y - 1 >= 0 && z + 2 < M) {
                    int temp = arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y - 1][z + 1];
                    if (temp > answer) answer = temp;
                }

            }
        }
        System.out.println(answer);

    }
}
