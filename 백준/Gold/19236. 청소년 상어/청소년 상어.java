
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int[][][] arr;
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    public static int[][][] moveFish(int map[][][]) {
        int count =0;

        int clone[][][]=new int[4][4][2];
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                clone[i][j][0] =map[i][j][0];
                clone[i][j][1] =map[i][j][1];
                if(clone[i][j][0]>0)count ++;
            }
        }

        HashSet<Integer> set=new HashSet<>();


        int dir = 0;
        while(count-->0) {

            int min = Integer.MAX_VALUE;
            int yy=0;
            int xx=0;
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    if(clone[i][j][0]>0&&
                            clone[i][j][0]<min&&
                            !set.contains(clone[i][j][0])) {
                        //최소 물고기 번호 갱신.
                        min = clone[i][j][0];
                        dir = clone[i][j][1];
                        xx=i;
                        yy=j;
                    }
                }
            }
            set.add(min);
            int nextY=0;
            int nextX=0;
            while(true) {
                nextY = yy + dy[dir];
                nextX = xx + dx[dir];
                if(nextY<0||nextX<0||nextY>=4||nextX>=4)
                    dir ++;
                else if(clone[nextX][nextY][0]== -1)
                    dir++;
                else
                    break;

                if(dir>8)
                    dir=1;
            }
            int temp1 = clone[xx][yy][0];
            int temp2 = dir;
            clone[xx][yy][0] = clone[nextX][nextY][0];
            clone[xx][yy][1] = clone[nextX][nextY][1];
            clone[nextX][nextY][0] =temp1;
            clone[nextX][nextY][1] =temp2;

        }

        return clone;



    }

    private static void D(int[][][] arr, int sum) {
        answer = Math.max(answer, sum);

        int[][][] copy = moveFish(arr);

        int sharkX = 0;
        int sharkY = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (copy[i][j][0] == -1) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }
        int preX = sharkX;
        int preY = sharkY;

        int dir = copy[sharkX][sharkY][1];

        for (int p = 0; p < 3; p++) {
            int[][][] newArr = new int[4][4][2];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    newArr[i][j] = copy[i][j].clone();
                }
            }

            sharkX += dx[dir];
            sharkY += dy[dir];
            if (sharkX < 0 || sharkY < 0 || sharkX >= 4 || sharkY >= 4) break;
            if (newArr[sharkX][sharkY][0] > 0) {
                newArr[preX][preY][0] = 0;
                newArr[preX][preY][1] = 0;
                int temp = newArr[sharkX][sharkY][0];
                newArr[sharkX][sharkY][0] = -1;
                D(newArr, sum +temp);
            }
        }

    }



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


}
