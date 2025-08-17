import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, score;
    static int[][] arr = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        score = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            switch (t) {
                case 1: {
                    move1(x, y);
                    check();
                    last();
                    break;
                }
                case 2: {
                    move2(x, y);
                    check();
                    last();
                    break;
                }
                case 3: {
                    move3(x, y);
                    check();
                    last();
                    break;
                }
            }
        }
        int restCount = 0;
        for (int[] x : arr) {
            for (int i : x) {
//                System.out.print(i + " ");
                if (i == 1) restCount++;
            }
//            System.out.println();
        }
        System.out.println(score);
        System.out.println(restCount);
    }

    private static void move1(int x, int y) {
        int tx = x;
        int ty = y;
        while (tx + 1 < 10 && arr[tx + 1][y] == 0) {
            tx++;
        }
        while (ty + 1 < 10 && arr[x][ty + 1] == 0) {
            ty++;
        }
        arr[tx][y] = 1;
        arr[x][ty] = 1;
    }

    private static void move2(int x, int y) {
        int tx = x;
        int ty = y;
        int ty2 = y + 1;
        while (tx + 1 < 10 && arr[tx + 1][y] == 0 && arr[tx + 1][ty2] == 0) {
            tx++;
        }
        arr[tx][ty] = 1;
        arr[tx][ty2] = 1;
        tx = x;
        ty = y + 1;
        while (ty + 1 < 10 && arr[x][ty + 1] == 0) {
            ty++;
        }
        arr[tx][ty] = 1;
        arr[tx][ty - 1] = 1;
    }

    private static void move3(int x, int y) {
        int tx = x;
        int tx2 = x + 1;
        int ty = y;
        while (tx2 + 1 < 10 && arr[tx2 + 1][y] == 0) {
            tx2++;
        }
        arr[tx2][ty] = 1;
        arr[tx2 - 1][ty] = 1;

        tx = x;
        tx2 = x + 1;
        ty = y;
        while (ty + 1 < 10 && arr[tx][ty + 1] == 0 && arr[tx2][ty + 1] == 0) {
            ty++;
        }
        arr[tx][ty] = 1;
        arr[tx2][ty] = 1;

    }

    private static void check() {
        //초록 점수
        for (int i = 9; i >= 6; i--) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                score++;
                for (int j = i; j >= 4; j--) {
                    for (int k = 0; k < 4; k++) {
                        arr[j][k] = arr[j - 1][k];
                    }
                }
                i++;
            }
        }

        //파랑 점수
        for (int j = 9; j >= 6; j--) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (arr[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                score++;
                for (int z = j; z >= 4; z--) {
                    for (int i = 0; i < 4; i++) {
                        arr[i][z] = arr[i][z - 1];
                    }
                }
                j++;
            }
        }
    }

    private static void last() {
        //연한 초록색에 존재하는 행 개수 구하기
        int greenCnt = 0;
        for (int i = 4; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 1) {
                    greenCnt++;
                    break;
                }
            }
        }
        if (greenCnt == 1) {
            for (int i = 9; i >= 5; i--) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        if (greenCnt == 2) {
            for (int i = 9; i >= 6; i--) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = arr[i - 2][j];
                }
            }
        }

        int blueCnt = 0;
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[j][i] == 1) {
                    blueCnt++;
                    break;
                }
            }
        }
        if (blueCnt == 1) {
            for (int i = 9; i >= 5 ; i--) {
                for (int j = 0; j < 4; j++) {
                    arr[j][i] = arr[j][i - 1];
                }
            }
        }

        if (blueCnt == 2) {
            for (int i = 9; i >= 6 ; i--) {
                for (int j = 0; j < 4; j++) {
                    arr[j][i] = arr[j][i - 2];
                }
            }
        }

        for (int i = 4; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                arr[j][i] = 0;
            }
        }
    }

}
