import java.util.*;
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] last = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) last[j]++;
                else last[j] = 0;
            }
            int[] clone = last.clone();
            Arrays.sort(clone);
            // System.out.println(Arrays.toString(clone));

            int k = 1;
            for (int j = m - 1; j >= 0; j--) {
                max = Math.max(max, clone[j] * k++);
            }
        }
        

        return max;
    }
}