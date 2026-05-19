import java.util.*;
class Solution {
    public int minRemoval(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int s = nums[0];
        int e = nums[nums.length - 1];
        if (e <= (long) s * k) return 0;

        long res = Long.MAX_VALUE;
        
        int j = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while ((long) k * nums[j] < nums[i]) {
                j++;
            }
            max = Math.max(max, i - j + 1);
        }

        return nums.length - max;

    }
}