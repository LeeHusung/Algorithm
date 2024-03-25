import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, max;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        max = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D(0);
        System.out.println(max);

    }

    private static void D(int L) {
        int c = check();
        max = Math.max(max, c);
        if (L == 5) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] temp = new int[n][n];
            for (int j = 0; j < n; j++) {
                temp[j] = arr[j].clone(); // 재귀 호출 전의 상태를 temp에 저장
            }

            move(i);
            D(L + 1);

            for (int j = 0; j < n; j++) {
                arr[j] = temp[j].clone(); // 재귀 호출 후 원본 배열을 temp의 상태로 복원
            }
        }


    }

    private static void move(int dir) {
        if (dir == 0) { //up
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > 0) {
                        int x = arr[i][j];
                        for (int k = i + 1; k < n; k++) {
                            int y = arr[k][j];
                            if (y == 0) continue;
                            if (x == y) {
                                arr[i][j] += y;
                                arr[k][j] -= y;
                                break;
                            } else if (x != 0 && y != 0 && x != y) {
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                        for (int k = i + 1; k < n; k++) {
                            if (arr[k][j] > 0) {
                                arr[i][j] = arr[k][j];
                                arr[k][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (dir == 1) { //down
            for (int i = n-1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > 0) {
                        int x = arr[i][j];
                        for (int k = i - 1; k >= 0; k--) {
                            int y = arr[k][j];
                            if (y == 0) continue;
                            if (x == y) {
                                arr[i][j] += y;
                                arr[k][j] -= y;
                                break;
                            } else if (x != 0 && y != 0 && x != y) {
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = n-1; i >= 1; i--) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (arr[k][j] > 0) {
                                arr[i][j] = arr[k][j];
                                arr[k][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (dir == 2) { //left
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] > 0) {
                        int x = arr[j][i];
                        for (int k = i + 1; k < n; k++) {
                            int y = arr[j][k];
                            if (y == 0) continue;
                            if (x == y) {
                                arr[j][i] += y;
                                arr[j][k] -= y;
                                break;
                            } else if (x != 0 && y != 0 && x != y) {
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] == 0) {
                        for (int k = i + 1; k < n; k++) {
                            if (arr[j][k] > 0) {
                                arr[j][i] = arr[j][k];
                                arr[j][k] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (dir == 3) { //right
            for (int i = n-1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] > 0) {
                        int x = arr[j][i];
                        for (int k = i - 1; k >= 0; k--) {
                            int y = arr[j][k];
                            if (y == 0) continue;
                            if (x == y) {
                                arr[j][i] += y;
                                arr[j][k] -= y;
                                break;
                            } else if (x != 0 && y != 0 && x != y) {
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = n-1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] == 0) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (arr[j][k] > 0) {
                                arr[j][i] = arr[j][k];
                                arr[j][k] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static int check() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }

}
