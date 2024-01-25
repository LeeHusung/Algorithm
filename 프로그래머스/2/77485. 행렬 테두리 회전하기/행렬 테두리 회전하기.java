class Solution {
    static int[][] arr;
    
    public int turn(int[] query) {
        int min = Integer.MAX_VALUE;
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        int k = arr[x1][y2];
        
        for (int i = y2; i > y1; i--) {
            arr[x1][i] = arr[x1][i-1];
            min = Math.min(min, arr[x1][i]);
        }
        for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            min = Math.min(min, arr[i][y1]);
        }
        for (int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            min = Math.min(min, arr[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i-1][y2];
            min = Math.min(min, arr[i][y2]);
        }
        arr[x1 + 1][y2] = k;
        min = Math.min(min, k);
        return min;
        
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        
        int cnt = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = cnt++;
            }
        }
        
        int idx = 0;
        for (int[] x : queries) {
            int min = turn(x);
            answer[idx++] = min;
            // for (int i = 0; i < rows; i++) {
            //     for (int j = 0; j < columns; j++) {
            //         System.out.print(arr[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
        
        
        
        
        
        return answer;
    }
}