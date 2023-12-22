import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        int[] count;
        if (r == 1) {
            count = new int[1];
            count[0] = Integer.parseInt(br.readLine());
        } else {
            String[] s1 = br.readLine().split(" ");
            count = new int[s1.length];
            for (int i = 0; i < s1.length; i++) {
                count[i] = Integer.parseInt(s1[i]);
            }
        }

        int[][] tmp = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        for (int num : count) {
//            System.out.println("===============");
            switch (num) {
                case 1:
                    button1();
                    break;
                case 2:
                    button2();
                    break;
                case 3:
                    button3();
                    int temp = n;
                    n = m;
                    m = temp;
                    break;
                case 4:
                    button4();
                    int temp1 = n;
                    n = m;
                    m = temp1;
                    break;
                case 5:
                    button5();
                    break;
                case 6:
                    button6();
                    break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void button1() {//상하 반전
        int idx = n - 1;
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = arr[idx][j];
            }
            idx--;
        }
        arr = temp;
    }

    public static void button2() {//좌우 반전
        int idx = m - 1;
        int[][] temp = new int[n][m];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                temp[i][j] = arr[i][idx];
            }
            idx--;
        }
        arr = temp;
    }

    public static void button3() {//오른쪽으로 90도 회전
        int idx = n - 1;
        int[][] temp = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][idx] = arr[i][j];
            }
            idx--;
        }
        arr = temp;
    }

    public static void button4() {
        int[][] temp1 = new int[m][n];
        Queue<Integer> temp = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp.add(arr[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                temp1[j][i] = temp.poll();
            }
        }
        arr = temp1;
    }

    public static void button5() {
        int[][] temp = new int[n][m];
        int x = n / 2;
        int y = m / 2;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j + y] = arr[i][j];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i + x][j + y] = arr[i][j + y];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i + x][j] = arr[i + x][j + y];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j] = arr[i + x][j];
            }
        }
        arr = temp;
    }

    public static void button6() {
        int[][] temp = new int[n][m];
        int x = n / 2;
        int y = m / 2;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i + x][j + y] = arr[i + x][j];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j + y] = arr[i + x][j + y];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i + x][j] = arr[i][j];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j] = arr[i][j + y];
            }
        }
        arr = temp;
    }

}
