import java.util.*;
class Solution {
    public int minRemoval(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        // System.out.println(nums.length);
        // System.out.println(Arrays.toString(nums));
        int s = nums[0];
        int e = nums[nums.length - 1];
        if (e <= (long) s * k) return 0;

        long res = Long.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            long limit = (long) nums[i] * k;
            int start = i + 1;
            int end = nums.length - 1;
            while (start <= end) {
                int middle = (start + end) / 2;
                if (nums[middle] > limit) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            // System.out.println("end: " + end);
            // System.out.println(i + nums.length - end - 1);
            res = Math.min(res, i + nums.length - end - 1);
        }
        


        return (int) res;

    }
}