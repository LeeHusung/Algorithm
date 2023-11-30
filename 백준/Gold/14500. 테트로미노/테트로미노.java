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

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 23; i++) {
            map.put((char) ('a' + i), 0);
        }

        for (int y = 0; y < N; y++) {
            for (int z = 0; z < M; z++) {
                if (z + 3 < M) {
                    map.put('a', arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y][z + 3]);
                }
                if (y + 3 < N) {
                    map.put('b', arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y + 3][z]);
                }
                if (z + 1 < M && y + 1 < N) {
                    map.put('c', arr[y][z] + arr[y + 1][z] + arr[y][z + 1] + arr[y + 1][z + 1]);
                }
                if (y + 2 < N && z + 1 < M) {
                    map.put('d', arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y + 2][z + 1]);
                }
                if (y - 2 >= 0 && z + 1 < M) {
                    map.put('e', arr[y][z] + arr[y][z + 1] + arr[y - 1][z + 1] + arr[y - 2][z + 1]);
                }
                if (y + 2 < N && z + 1 < M) {
                    map.put('f', arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y][z + 1]);
                }
                if (y + 2 < N && z + 1 < M) {
                    map.put('g', arr[y][z] + arr[y][z + 1] + arr[y + 1][z + 1] + arr[y + 2][z + 1]);
                }
                if (y + 1 < N && z + 2 < M) {
                    map.put('h', arr[y][z] + arr[y + 1][z] + arr[y][z + 1] + arr[y][z + 2]);
                }
                if (y + 1 < N && z + 2 < M) {
                    map.put('i', arr[y][z] + arr[y + 1][z] + arr[y + 1][z + 1] + arr[y + 1][z + 2]);
                }
                if (y + 1 < N && z + 2 < M) {
                    map.put('j', arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y + 1][z + 2]);
                }
                if (y - 1 >= 0 && z + 2 < M) {
                    map.put('k', arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y - 1][z + 2]);
                }
                if (y + 2 < N && z + 1 < M) {
                    map.put('l', arr[y][z] + arr[y + 1][z] + arr[y + 1][z + 1] + arr[y + 2][z + 1]);
                }
                if (y - 1 >= 0 && y + 1 < N && z + 1 < M) {
                    map.put('m', arr[y][z] + arr[y][z + 1] + arr[y + 1][z] + arr[y - 1][z + 1]);
                }
                if (y - 1 >= 0 && z + 2 < M) {
                    map.put('n', arr[y][z] + arr[y][z + 1] + arr[y - 1][z + 1] + arr[y - 1][z + 2]);
                }
                if (y + 1 < N && z + 2 < M) {
                    map.put('o', arr[y][z] + arr[y][z + 1] + arr[y + 1][z + 1] + arr[y + 1][z + 2]);
                }
                if (y + 1 < N && z + 2 < M) {
                    map.put('p', arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y + 1][z + 1]);
                }
                if (y + 1 < N && y - 1 >= 0 && z + 1 < M) {
                    map.put('q', arr[y][z] + arr[y][z + 1] + arr[y - 1][z + 1] + arr[y + 1][z + 1]);
                }
                if (y + 2 < N && z + 1 < M) {
                    map.put('r', arr[y][z] + arr[y + 1][z] + arr[y + 2][z] + arr[y + 1][z + 1]);
                }
                if (y - 1 >= 0 && z + 2 < M) {
                    map.put('s', arr[y][z] + arr[y][z + 1] + arr[y][z + 2] + arr[y - 1][z + 1]);
                }
//                if (y + 1 < N && z + 2 < M) {
//                    map.put('t', arr[y][z] + arr[y][z + 1] + arr[y + 1][z + 1] + arr[y][z + 2]);
//                }
//                if (y + 2 < N && z + 1 < M) {
//                    map.put('u', arr[y][z] + arr[y + 1][z] + arr[y + 1][z + 1] + arr[y + 2][z]);
//                }
//                if (y + 1 < N && z + 2 < M) {
//                    map.put('v', arr[y][z] + arr[y][z + 1] + arr[y + 1][z + 1] + arr[y + 1][z + 2]);
//                }
//                if (y + 1 < N && y - 1 >= 0 && z + 1 < M) {
//                    map.put('w', arr[y][z] + arr[y + 1][z] + arr[y - 1][z + 1] + arr[y][z + 1]);
//                }

                int max = 0;
                for (char ch : map.keySet()) {
                    max = Math.max(max, map.get(ch));
                }
                tmp[y][z] = max;
            }
        }

        int answer = 0;
        for (int t = 0; t < N; t++) {
            for (int u = 0; u < M; u++) {
                answer = Math.max(answer, tmp[t][u]);
            }
        }

        System.out.println(answer);



    }
}
