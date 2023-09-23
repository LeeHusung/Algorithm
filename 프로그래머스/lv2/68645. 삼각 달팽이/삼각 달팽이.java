class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*n + n) / 2];
        
        int[][] arr = new int[n][n];
        
        int x = -1, y = 0, num = 1;
        int direction = 0;
        
        for (int i = n; i>0; i--) {
            for (int j = 0; j<i; j++) {
                if (direction == 0) {
                    x++;
                } else if (direction == 1) {
                    y++;
                } else if (direction == 2) {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
            
            direction++;
            direction %= 3;
        }
        
        
        
        // int l = n-1;
        // while (arr[x][y] == 0 && x < n && y < n) {
        //     while (arr[x][y] == 0 && x < l) {
        //         arr[x++][y] = num++;
        //     }
        //     while (arr[x][y] == 0 && y < l) {
        //         arr[x][y++] = num++;
        //     }
        //     while (arr[x][y] == 0 && x > 1 && y > 1) {
        //         arr[x--][y--] = num++;
        //     }
        //     l--;
        // }
        
        int idx = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<=i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        
        return answer;
    }
}