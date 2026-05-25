import java.util.*;
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int negativeCnt = 0;
        long sum = 0;
          int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= 0) {
                    negativeCnt++;
                }
                sum += Math.abs(matrix[i][j]);
            }
        }
        if (negativeCnt % 2 == 0) {
            return sum;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    min = Math.min(min, Math.abs(matrix[i][j]));
                }
            }
        }
        return sum - min - min;
    }
}