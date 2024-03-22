import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int oBingo;
    static int xBingo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            oBingo = 0;
            xBingo = 0;
            String input = br.readLine();
            if (input.equals("end")) break;
            int[][] arr = new int[3][3];
            String[] s = input.split("");
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[cnt].equals("X")) {
                        arr[i][j] = 1;
                        cnt++;
                    }
                    else if (s[cnt].equals("O")) {
                        arr[i][j] = 2;
                        cnt++;
                    }
                    else cnt++;
                }
            }
            boolean flag = check(arr);
            if (flag) sb.append("valid").append("\n");
            else sb.append("invalid").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int[][] arr) {
        checkBingo(arr);
        boolean full = checkFull(arr);
        if (xBingo == 0 && oBingo == 0 && !full) return false;
        int oCnt = 0;
        int xCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 1) xCnt++;
                else if (arr[i][j] == 2) oCnt++;
            }
        }
        if (oCnt > xCnt) return false;
        if (Math.abs(oCnt - xCnt) > 1) return false;
        if (xBingo > 2 || oBingo >= 2) return false;
        if (oBingo == 1) {
            if (oCnt != xCnt) return false;
        }
        if (xBingo >= 1) {
            if (xCnt - oCnt != 1) return false;
        }
        return true;
    }

    private static boolean checkFull(int[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static void checkBingo(int[][] arr) {
        if (arr[0][0] == 1 && arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2]) xBingo++;
        if (arr[0][0] == 2 && arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2]) oBingo++;
        if (arr[0][0] == 1 && arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0]) xBingo++;
        if (arr[0][0] == 2 && arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0]) oBingo++;
        if (arr[0][0] == 1 && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) xBingo++;
        if (arr[0][0] == 2 && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) oBingo++;

        if (arr[1][1] == 1 && arr[1][1] == arr[0][1] && arr[1][1] == arr[2][1]) xBingo++;
        if (arr[1][1] == 2 && arr[1][1] == arr[0][1] && arr[1][1] == arr[2][1]) oBingo++;
        if (arr[1][1] == 1 && arr[1][1] == arr[1][0] && arr[1][1] == arr[1][2]) xBingo++;
        if (arr[1][1] == 2 && arr[1][1] == arr[1][0] && arr[1][1] == arr[1][2]) oBingo++;
        if (arr[1][1] == 1 && arr[1][1] == arr[0][2] && arr[1][1] == arr[2][0]) xBingo++;
        if (arr[1][1] == 2 && arr[1][1] == arr[0][2] && arr[1][1] == arr[2][0]) oBingo++;

        if (arr[2][2] == 1 && arr[2][2] == arr[0][2] && arr[2][2] == arr[1][2]) xBingo++;
        if (arr[2][2] == 2 && arr[2][2] == arr[0][2] && arr[2][2] == arr[1][2]) oBingo++;
        if (arr[2][2] == 1 && arr[2][2] == arr[2][0] && arr[2][2] == arr[2][1]) xBingo++;
        if (arr[2][2] == 2 && arr[2][2] == arr[2][0] && arr[2][2] == arr[2][1]) oBingo++;
    }
}