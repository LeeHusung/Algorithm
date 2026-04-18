import java.util.*;
class Solution {
    public int longestBalanced(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int start = nums[i];
            Set<Integer> oddSet = new HashSet<>();
            Set<Integer> evenSet = new HashSet<>();
            if (start % 2 == 0) {
                    evenSet.add(start);
                } else {
                    oddSet.add(start);
                }
            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                if (next % 2 == 0) {
                    evenSet.add(next);
                } else {
                    oddSet.add(next);
                }
                if (evenSet.size() == oddSet.size()) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}